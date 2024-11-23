package com.backEnd.Tecnolo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.backEnd.Tecnolo.dto.Usuario_RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backEnd.Tecnolo.model.Usuario;
import com.backEnd.Tecnolo.repository.Usuario_Repository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private Usuario_Repository repository;

    // get de usuario sem id
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // get de usuario com id
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario_RequestDTO dto) {

        if (dto.getNome() == null) {
            return ResponseEntity.badRequest().body("O Nome do usuario é Obrigatorio");
        }

        if (dto.getEmail() == null) {
            return ResponseEntity.badRequest().body("O email deve ser Obrigatorio");
        }

        if (dto.getSenha() == null) {
            return ResponseEntity.badRequest().body("A Senha deve Ser Obrigatorio");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setAdmin(dto.getAdmin());

        // validação data de criação do usuario
        if (dto.getData() == null){
            usuario.setData(Timestamp.valueOf(LocalDateTime.now()));
        } else {
            usuario.setData(dto.getData());
        }

        Usuario saveUsuario = repository.save(usuario);
        return ResponseEntity.ok(saveUsuario);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Usuario_RequestDTO dto) {

            Optional<Usuario> usuarioOpt = repository.findById(id);

        if (dto.getNome() == null) {
            return ResponseEntity.badRequest().body("O Nome do usuario é Obrigatorio");
        }

        if (dto.getEmail() == null) {
            return ResponseEntity.badRequest().body("O email deve ser Obrigatorio");
        }
            // para realizar a alteração da senha a senha deve ser preenchida
        if (dto.getSenha() == null) {
            return ResponseEntity.badRequest().body("A Senha deve Ser Obrigatorio");
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setAdmin(dto.getAdmin());

        // validação data de criação do usuario
        if (dto.getData() == null){
            usuario.setData(Timestamp.valueOf(LocalDateTime.now()));
        } else {
            usuario.setData(dto.getData());
        }

        Usuario saveUsuario = repository.save(usuario);
        return ResponseEntity.ok(saveUsuario);

    }

    // delete do usuario com id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Usuario> usuarioOpt = repository.findById(id);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario não encontrado com o id fornecido");
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Usuario deletado com sucesso.");
    }
}
