package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.dto.Categoria_RequestDTO;
import com.backEnd.Tecnolo.model.Categoria;
import com.backEnd.Tecnolo.repository.Categoria_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class categoriaController {

    @Autowired
    private Categoria_Repository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categoria = this.repository.findAll();
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Categoria_RequestDTO dto) {
        // Validação de categoria
        if (dto.getNome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());

        Categoria savedItem = repository.save(categoria);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Categoria_RequestDTO dto) {
        // Validação de categoria
        if (dto.getNome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        // Atualizar o item
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        // Verificar se o item existe
        Categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        // Deletar o item
        repository.deleteById(id);
        return ResponseEntity.ok().body("Item deletado com sucesso.");
    }

}
