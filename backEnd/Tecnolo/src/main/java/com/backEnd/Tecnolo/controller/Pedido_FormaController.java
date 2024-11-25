package com.backEnd.Tecnolo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backEnd.Tecnolo.model.PedidoForma;
import com.backEnd.Tecnolo.repository.PedidoForma_Repository;


@RestController
@RequestMapping("/api/pedido_forma")
public class Pedido_FormaController {

    private PedidoForma_Repository repository;

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

}
