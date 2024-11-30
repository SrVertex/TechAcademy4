package com.backEnd.Tecnolo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backEnd.Tecnolo.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //  MUITO CUITDADO ISSO PODE QUEBRAR TODO O SITE

    //  MUITO CUITDADO ISSO PODE QUEBRAR TODO O SITE

    //  MUITO CUITDADO ISSO PODE QUEBRAR TODO O SITE

    //  MUITO CUITDADO ISSO PODE QUEBRAR TODO O SITE

    //  MUITO CUITDADO ISSO PODE QUEBRAR TODO O SITE

    //  MUITO CUITDADO ISSO PODE QUEBRAR TODO O SITE

    // Variável estática para armazenar o ID do usuário logado
    private static Integer loggedUserId = null;

    public static Integer getLoggedUserId() {
        return loggedUserId;
    }

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


    private final HashMap<String, String> passwordResetTokens = new HashMap<>();

    @PostMapping("/verificar-usuario")
    public ResponseEntity<?> verificarUsuario(@RequestBody Usuario_RequestDTO dto) {
        if (dto.getEmail() == null || dto.getNome() == null) {
            return ResponseEntity.badRequest().body("O nome e o e-mail do usuário são obrigatórios.");
        }

        // Buscar o usuário com o nome e email fornecidos
        Optional<Usuario> usuarioOpt = repository.findAll().stream()
                .filter(u -> u.getEmail().equals(dto.getEmail()) && u.getNome().equals(dto.getNome()))
                .findFirst();

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado com o nome e e-mail fornecidos.");
        }

        // Gerar token de redefinição de senha
        String token = UUID.randomUUID().toString();
        passwordResetTokens.put(dto.getEmail(), token);
        System.out.println("Token gerado para " + dto.getEmail() + ": " + token); // LOG DE DEBUG

        return ResponseEntity.ok("Usuário verificado. Token gerado para redefinição de senha.");
    }

    @PutMapping("/alterar-senha")
    public ResponseEntity<?> alterarSenha(@RequestBody Usuario_RequestDTO dto) {
        if (dto.getEmail() == null) {
            return ResponseEntity.badRequest().body("O e-mail do usuário é obrigatório.");
        }
        if (dto.getSenha() == null) {
            return ResponseEntity.badRequest().body("A nova senha deve ser informada.");
        }

        System.out.println("E-mail recebido para alteração de senha: " + dto.getEmail()); // LOG DE DEBUG

        // Verificar se existe uma solicitação de redefinição para o e-mail
        String token = passwordResetTokens.get(dto.getEmail());
        if (token == null) {
            System.out.println("Nenhum token encontrado para o e-mail: " + dto.getEmail()); // LOG DE DEBUG
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nenhuma solicitação de redefinição encontrada para este e-mail.");
        }

        // Buscar usuário pelo e-mail
        Optional<Usuario> usuarioOpt = repository.findAll().stream()
                .filter(u -> u.getEmail().equals(dto.getEmail()))
                .findFirst();

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado com o e-mail fornecido.");
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setSenha(dto.getSenha());
        repository.save(usuario);

        // Remover o token após a redefinição bem-sucedida
        passwordResetTokens.remove(dto.getEmail());
        System.out.println("Senha alterada e token removido para o e-mail: " + dto.getEmail()); // LOG DE DEBUG

        return ResponseEntity.ok("Senha alterada com sucesso.");
    }


}
