package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.dto.Item_RequestDTO;
import com.backEnd.Tecnolo.model.Item;
import com.backEnd.Tecnolo.repository.Item_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private Item_Repository repository;

    @GetMapping
    public ResponseEntity<List<Item>> findAll(){
        List<Item> item = this.repository.findAll();
        return ResponseEntity.ok(item);
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody Item_RequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Item item = new Item();
        item.setNome(dto.nome());

        this.repository.save(item);
        return ResponseEntity.ok(item);
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
