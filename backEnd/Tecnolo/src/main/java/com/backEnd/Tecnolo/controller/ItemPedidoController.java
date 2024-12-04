package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.dto.ItemPedido_RequestDTO;
import com.backEnd.Tecnolo.dto.Item_RequestDTO;
import com.backEnd.Tecnolo.model.*;
import com.backEnd.Tecnolo.repository.ItemPedido_Repository;
import com.backEnd.Tecnolo.repository.Item_Repository;
import com.backEnd.Tecnolo.repository.Pedido_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ItemPedido")
public class ItemPedidoController {

    @Autowired
    private Item_Repository itemRepository;

    @Autowired
    private Pedido_Repository pedidoRepository;

    @Autowired
    private ItemPedido_Repository itemPedidoRepository;


    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll(){
        List<ItemPedido> itemPedidos = this.itemPedidoRepository.findAll();
        return ResponseEntity.ok(itemPedidos);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody ItemPedido_RequestDTO dto) {


        // Recupera o ID do usuário logado
        Integer pedido = PedidoController.getMaxId();

        // Usa o ID do usuário logado se estiver presente, senão utiliza o ID fornecido no DTO
        Integer pedidoid = (pedido != null) ? pedido : dto.getPedido_id();

        if (pedidoid == null) {
            return ResponseEntity.badRequest().body("É necessário informar o ID do pedido ou estar logado.");
        }


        ItemPedidoPK itemPedidoPK = new ItemPedidoPK();
        itemPedidoPK.setItemId(dto.getItem_id());
        itemPedidoPK.setPedidoId(dto.getPedido_id());

        Optional<Item> itemOtp = itemRepository.findById(dto.getItem_id());
        Optional<Pedido> pedidoOtp = pedidoRepository.findById(pedidoid);

        if (itemOtp.isEmpty() || pedidoOtp.isEmpty()) {
            return ResponseEntity.badRequest().body("Item não encontrado com o ID fornecido.");
        }

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setItem(itemOtp.get());
        itemPedido.setPedido(pedidoOtp.get());
        itemPedido.setId(itemPedidoPK);

        ItemPedido savedItem = itemPedidoRepository.save(itemPedido);
        return ResponseEntity.ok(savedItem);
    }
}
