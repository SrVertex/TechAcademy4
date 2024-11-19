package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.dto.Item_RequestDTO;
import com.backEnd.Tecnolo.model.*;
import com.backEnd.Tecnolo.repository.Categoria_Repository;
import com.backEnd.Tecnolo.repository.Item_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private Item_Repository repository;

    @Autowired
    private Categoria_Repository categoriaRepository;


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
    public ResponseEntity<?> save(@RequestBody Item_RequestDTO dto) {
        // Validação de categoria
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getCategoria_id());
        if (categoriaOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Categoria não encontrada com o ID fornecido.");
        }

        Item item = new Item();
        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        item.setPreco(dto.getPreco());
        item.setFoto(dto.getFoto());
        item.setAtributo_1(dto.getAtributo_1());
        item.setAtributo_2(dto.getAtributo_2());
        item.setAtributo_3(dto.getAtributo_3());
        item.setAtributo_4(dto.getAtributo_4());
        item.setAtributo_5(dto.getAtributo_5());
        item.setAtributo_6(dto.getAtributo_6());
        item.setEstoque(dto.getEstoque());
        item.setCategoria(categoriaOpt.get());

        Item savedItem = repository.save(item);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Item_RequestDTO dto) {
        // Verificar se o item existe
        Optional<Item> itemOpt = repository.findById(id);
        if (itemOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Item não encontrado com o ID fornecido.");
        }

        // Validação de categoria
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getCategoria_id());
        if (categoriaOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Categoria não encontrada com o ID fornecido.");
        }

        // Atualizar o item
        Item item = itemOpt.get();
        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        item.setPreco(dto.getPreco());
        item.setFoto(dto.getFoto());
        item.setAtributo_1(dto.getAtributo_1());
        item.setAtributo_2(dto.getAtributo_2());
        item.setAtributo_3(dto.getAtributo_3());
        item.setAtributo_4(dto.getAtributo_4());
        item.setAtributo_5(dto.getAtributo_5());
        item.setAtributo_6(dto.getAtributo_6());
        item.setEstoque(dto.getEstoque());
        item.setCategoria(categoriaOpt.get());

        Item savedItem = repository.save(item);
        return ResponseEntity.ok(savedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        // Verificar se o item existe
        Optional<Item> itemOpt = repository.findById(id);
        if (itemOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Item não encontrado com o ID fornecido.");
        }

        // Deletar o item
        repository.deleteById(id);
        return ResponseEntity.ok().body("Item deletado com sucesso.");
    }




//    @PostMapping
//    public ResponseEntity<Item> save(@RequestBody Item_RequestDTO dto) {
//        if (dto.nome().isEmpty()) {
//            return ResponseEntity.status(428).build();
//        }
//
//        Item item = new Item();
//        item.setNome(dto.nome());
//
//        this.repository.save(item);
//        return ResponseEntity.ok(item);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        Item item = this.repository.findById(id)
//                .orElseThrow(() ->
//                        new IllegalArgumentException("Item não foi encontrado"));
//
//        this.repository.delete(item);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody Item_RequestDTO dto) {
//        if (dto.nome().isEmpty()) {
//            return ResponseEntity.status(428).build();
//        }
//
//        Item item = this.repository.findById(id)
//                .orElseThrow(() ->
//                        new IllegalArgumentException("Item não foi encontrado"));
//
//        item.setNome(dto.nome());
//
//        this.repository.save(item);
//        return ResponseEntity.ok(item);
//    }


}