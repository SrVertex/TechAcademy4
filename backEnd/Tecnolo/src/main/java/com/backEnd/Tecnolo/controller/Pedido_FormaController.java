package com.backEnd.Tecnolo.controller;

import java.util.List;

import com.backEnd.Tecnolo.dto.PedidoForma_Record_RequestDTO;
import com.backEnd.Tecnolo.dto.PedidoForma_RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backEnd.Tecnolo.model.PedidoForma;
import com.backEnd.Tecnolo.repository.PedidoForma_Repository;


@RestController
@RequestMapping("/api/pedido_forma")
public class Pedido_FormaController {

    @Autowired
    private PedidoForma_Repository repository;

    // interface do pedido
    @Autowired
    private PedidoForma_Repository pedidoFormaRepository;

    @GetMapping
    public ResponseEntity<List<PedidoForma>> findAll() {
        List<PedidoForma> pedidoFormas = this.repository.findAll();
        return ResponseEntity.ok(pedidoFormas);
    }

     // get de usuario com id
    @GetMapping("/{id}")
    public PedidoForma findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PedidoForma_RequestDTO dto) {

        PedidoForma pedidoforma = new PedidoForma();
        pedidoforma.setStatus(dto.getStatus());

        PedidoForma pedidoForma = repository.save(pedidoforma);
        return ResponseEntity.ok(pedidoForma);
    }



}
