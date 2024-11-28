package com.backEnd.Tecnolo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.backEnd.Tecnolo.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backEnd.Tecnolo.dto.Usuario_RequestDTO;
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

        // validação data de criação do usuario
        if (dto.getData() == null){
            usuario.setData(Timestamp.valueOf(LocalDateTime.now()));
        } else {
            usuario.setData(dto.getData());
        }

        Usuario saveUsuario = repository.save(usuario);
        return ResponseEntity.ok(saveUsuario);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Usuario> usuarioOpt = repository.findById(id);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario não encontrado com o id fornecido");
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Usuario deletado com sucesso.");
    }


    // Variável estática para armazenar o ID do usuário logado
    private static Integer loggedUserId = null;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        if (loginRequestDTO.getEmail() == null || loginRequestDTO.getSenha() == null) {
            return ResponseEntity.badRequest().body("Email e senha são obrigatórios.");
        }

        Optional<Usuario> usuarioOpt = repository.findAll().stream()
                .filter(u -> u.getEmail().equals(loginRequestDTO.getEmail()) && u.getSenha().equals(loginRequestDTO.getSenha()))
                .findFirst();

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }

        Usuario usuario = usuarioOpt.get();

        // Atualiza o ID do usuário logado
        loggedUserId = usuario.getId_usuario();

        return ResponseEntity.ok().body("Login realizado com sucesso! ID do usuário logado: " + loggedUserId);
    }


    @GetMapping("/logged-user")
    public ResponseEntity<?> getLoggedUser() {
        System.out.println("Verificando ID do usuário logado: " + loggedUserId);
        if (loggedUserId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nenhum usuário está logado no momento.");
        }
        return ResponseEntity.ok("ID do usuário logado: " + loggedUserId);
    }




}
