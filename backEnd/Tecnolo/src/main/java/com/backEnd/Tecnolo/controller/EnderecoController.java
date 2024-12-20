package com.backEnd.Tecnolo.controller;

import java.util.List;
import java.util.Optional;

import com.backEnd.Tecnolo.model.Usuario;
import com.backEnd.Tecnolo.repository.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backEnd.Tecnolo.dto.Endereco_RequestDTO;
import com.backEnd.Tecnolo.model.Endereco;
import com.backEnd.Tecnolo.repository.Endereco_Repository;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private Endereco_Repository repository;

    @Autowired
    private Usuario_Repository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> enderecos = this.repository.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public Endereco findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Endereço não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Endereco_RequestDTO dto) {

        // Recupera o ID do usuário logado
        Integer loggedUserId = UsuarioController.getLoggedUserId();

        // Usa o ID do usuário logado se estiver presente, senão utiliza o ID fornecido no DTO
        Integer usuarioId = (loggedUserId != null) ? loggedUserId : dto.getUsuario_id();

        if (usuarioId == null) {
            return ResponseEntity.badRequest().body("É necessário informar o ID do usuário ou estar logado.");
        }

            // pega o id qeu foi tratado e utiliza para ser enviadado para o endereço para saber que é o dono
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);

        // todos os if que estão a baixo vão de vereficar o campo esta vazio
        if (dto.getNome_destinatario() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getCep() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getCidade() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getUF() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getBairro() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getRua() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getNumero() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getContato() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        // cria um novo usuario
        Endereco endereco = new Endereco();
        endereco.setNome_destinatario(dto.getNome_destinatario());
        endereco.setCep(dto.getCep());
        endereco.setCidade(dto.getCidade());
        endereco.setUF(dto.getUF());
        endereco.setBairro(dto.getBairro());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setContato(dto.getContato());
        endereco.setUsuario(usuarioOpt.get()); // resebe o id do usario esta logado para ser envidado

        Endereco saveEndereco = repository.save(endereco);
        return ResponseEntity.ok(saveEndereco);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Endereco_RequestDTO dto) {

        Optional<Endereco> enderecoOpt = repository.findById(id);

        if (dto.getNome_destinatario() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getCep() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getCidade() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getUF() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getBairro() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getRua() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getNumero() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        if (dto.getContato() == null){
            return ResponseEntity.badRequest().body("O Campo é o Obrigatorio");
        }

        Endereco endereco = new Endereco();
        endereco.setNome_destinatario(dto.getNome_destinatario());
        endereco.setCep(dto.getCep());
        endereco.setCidade(dto.getCidade());
        endereco.setUF(dto.getUF());
        endereco.setBairro(dto.getBairro());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setContato(dto.getContato());

        Endereco saveEndereco = repository.save(endereco);
        return ResponseEntity.ok(saveEndereco);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Endereco> enderecoOpt = repository.findById(id);
        if (enderecoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Endereço não encontrado com o id Fornecido");
        }
        repository.deleteById(id);
        return ResponseEntity.badRequest().body("Endereco deletado com Sucesso!");
    }

}
