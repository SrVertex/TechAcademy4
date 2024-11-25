package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.model.PedidoForma;
import com.backEnd.Tecnolo.repository.PedidoForma_Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/pedido_forma")
public class Pedido_FormaController {

    private PedidoForma_Repository repository;

    @GetMapping
    public ResponseEntity<List<PedidoForma>> findAll() {
        List<PedidoForma> pedidoFormas = this.repository.findAll();
        return ResponseEntity.ok(pedidoFormas);
    }
}
