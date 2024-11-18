package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.dto.Item_RequestDTO;
import com.backEnd.Tecnolo.dto.Pedido_ResquestDTO;
import com.backEnd.Tecnolo.model.Item;
import com.backEnd.Tecnolo.model.Pedido;
import com.backEnd.Tecnolo.model.Usuario;
import com.backEnd.Tecnolo.repository.Pedido_Repository;
import com.backEnd.Tecnolo.repository.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private Pedido_Repository repository;

    @Autowired
    private Usuario_Repository usuarioRepository;


    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedido = this.repository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pedido_ResquestDTO dto) {

//                // Validação de valor e quantidade
//                if (dto.getValor() == null || dto.getQuantidade() <= 0) {
//                    return ResponseEntity.badRequest().body("Quantidade do pedido é obrigatória e deve ser maior que zero.");
//                }
//
//                // Validação de status
//                if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
//                    return ResponseEntity.badRequest().body("Status do pedido é obrigatório.");
//                }
//
//                // Validação de usuário
//                Optional<Usuario> usuarioOpt = usuarioRepository.findById(dto.getUsuarioId());
//                if (usuarioOpt.isEmpty()) {
//                    return ResponseEntity.badRequest().body("Usuário não encontrado com o ID fornecido.");
//                }
//
//                Pedido pedido = new Pedido();
//                pedido.setValor(dto.getValor());
//                pedido.setStatus(dto.getStatus());
//                pedido.setUsuario(usuarioOpt.get());
//
//                // Definir a data do pedido
//                if (dto.getDataPedido() == null) {
//                    pedido.setDataPedido(Timestamp.valueOf(LocalDateTime.now()));
//                } else {
//                    pedido.setDataPedido(dto.getDataPedido());
//                }
//
//                // Salvar o pedido
//                Pedido savedPedido = repository.save(pedido);
//                return ResponseEntity.ok(savedPedido);
//


//                // Validação de valor
//                if (dto.getValor() == null) {
//                    return ResponseEntity.badRequest().body("O valor do pedido é obrigatório.");
//                }
//
//                // Validação de status
//                if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
//                    return ResponseEntity.badRequest().body("Status do pedido é obrigatório.");
//                }
//
//                // Validação de usuário
//                Optional<Usuario> usuarioOpt = Usuario_Repository.findById(dto.getUsuario_id());
//                if (usuarioOpt.isEmpty()) {
//                    return ResponseEntity.badRequest().body("Usuário não encontrado com o ID fornecido.");
//                }
//
//                Pedido pedido = new Pedido();
//                pedido.setValor(dto.getValor());
//                pedido.setStatus(dto.getStatus());
//                pedido.setUsuario(usuarioOpt.id_usuario);
//
//
//                // Validação e definição da data do pedido
//
//                if (dto.getDataPedido() == null) {
//                    pedido.setDataPedido(Timestamp.valueOf(LocalDateTime.now()));
//                } else {
//                    pedido.setDataPedido(dto.getDataPedido());
//                }
//
//                // Salvar o pedido
//                Pedido savedPedido = repository.save(pedido);
//                return ResponseEntity.ok(savedPedido);


                // Validação de valor
                if (dto.getValor() == null) {
                    return ResponseEntity.badRequest().body("O valor do pedido é obrigatório.");
                }

                // Validação de status
                if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
                    return ResponseEntity.badRequest().body("Status do pedido é obrigatório.");
                }

                // Validação de usuário
                Optional<Usuario> usuarioOpt = usuarioRepository.findById(dto.getUsuario_id());
                if (usuarioOpt.isEmpty()) {
                    return ResponseEntity.badRequest().body("Usuário não encontrado com o ID fornecido.");
                }

                Pedido pedido = new Pedido();
                pedido.setValor(dto.getValor());
                pedido.setStatus(dto.getStatus());
                pedido.setUsuario(usuarioOpt.get());


                // Validação e definição da data do pedido
                if (dto.getData_pedido() == null) {
                    pedido.setData_pedido(Timestamp.valueOf(LocalDateTime.now()));
                } else {
                    pedido.setData_pedido(dto.getData_pedido());
                }

                // Salvar o pedido
                Pedido savedPedido = repository.save(pedido);
                return ResponseEntity.ok(savedPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Item item = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item não foi encontrado"));

        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody Item_RequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Item item = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item não foi encontrado"));

        item.setNome(dto.nome());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }


}
