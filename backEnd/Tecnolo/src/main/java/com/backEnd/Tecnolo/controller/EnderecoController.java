package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.dto.Endereco_RequestDTO;
import com.backEnd.Tecnolo.model.Endereco;
import com.backEnd.Tecnolo.repository.Endereco_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private Endereco_Repository repository;

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
        
        Endereco endereco = new Endereco();
        endereco.setBairro(dto.getBairro());

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
