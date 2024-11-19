package com.backEnd.Tecnolo.controller;

import com.backEnd.Tecnolo.dto.Categoria_RequestDTO;
import com.backEnd.Tecnolo.dto.FormaPGTO_RequestDTO;
import com.backEnd.Tecnolo.model.Categoria;
import com.backEnd.Tecnolo.model.FormaPGTO;
import com.backEnd.Tecnolo.repository.Categoria_Repository;
import com.backEnd.Tecnolo.repository.FormaPGTO_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formaPGTO")
public class formaPGTOController {

    @Autowired
    private FormaPGTO_Repository repository;

    @GetMapping
    public ResponseEntity<List<FormaPGTO>> findAll(){
        List<FormaPGTO> formaPGTO = this.repository.findAll();
        return ResponseEntity.ok(formaPGTO);
    }

    @GetMapping("/{id}")
    public FormaPGTO findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody FormaPGTO_RequestDTO dto) {
        // Validação de categoria
        if (dto.getTipo().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        FormaPGTO formaPGTO = new FormaPGTO();
        formaPGTO.setTipo(dto.getTipo());
        formaPGTO.setParcela(dto.getParcela());
        formaPGTO.setJuros(dto.getJuros());

        FormaPGTO savedItem = repository.save(formaPGTO);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody FormaPGTO_RequestDTO dto) {
        // Validação de categoria
        if (dto.getTipo().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        FormaPGTO formaPGTO = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        // Atualizar o item
        formaPGTO.setTipo(dto.getTipo());
        formaPGTO.setParcela(dto.getParcela());
        formaPGTO.setJuros(dto.getJuros());

        this.repository.save(formaPGTO);
        return ResponseEntity.ok(formaPGTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        // Verificar se o item existe
        FormaPGTO formaPGTO = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        // Deletar o item
        repository.deleteById(id);
        return ResponseEntity.ok().body("Item deletado com sucesso.");
    }
}
