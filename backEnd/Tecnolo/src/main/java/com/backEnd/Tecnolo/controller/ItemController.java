package com.backEnd.Tecnolo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backEnd.Tecnolo.dto.Item_RequestDTO;
import com.backEnd.Tecnolo.model.Categoria;
import com.backEnd.Tecnolo.model.Item;
import com.backEnd.Tecnolo.repository.Categoria_Repository;
import com.backEnd.Tecnolo.repository.Item_Repository;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    // Busca da interface de item
    @Autowired
    private Item_Repository repository;

    // busca de interface de categoria
    @Autowired
    private Categoria_Repository categoriaRepository;

    // metodo de get sem usar o id ele busca todos os itens que estão no banco de dados
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

        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getCategoria_id());
        if (categoriaOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado com o ID fornecido.");
        }  //        Categoria categoria = categoriaRepository.findById(dto.getCategoria_id()).get();


        // atributos que seram inserido do banco de dados
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

        // save do dados de criação do novo item
        Item savedItem = repository.save(item);
        return ResponseEntity.ok(savedItem);
    }

    // alter de item /aonde seram realzado a alteração do dados do item usando o id informado no front_end / sua estrutuda é parecudade com o post
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
        item.setAtributo_1(dto.getAtributo_1());
        item.setAtributo_2(dto.getAtributo_2());
        item.setAtributo_3(dto.getAtributo_3());
        item.setAtributo_4(dto.getAtributo_4());
        item.setAtributo_5(dto.getAtributo_5());
        item.setAtributo_6(dto.getAtributo_6());
        item.setEstoque(dto.getEstoque());
        item.setCategoria(categoriaOpt.get());

        //  realizar o updade do item
        Item savedItem = repository.save(item);
        return ResponseEntity.ok(savedItem);
    }

        //  deteleto do item
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        // verefica se o item esta armezenedao no banco de dados usado o id informado
        Optional<Item> itemOpt = repository.findById(id);
        if (itemOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Item não encontrado com o ID fornecido.");
        }

        // Deletar o item usando o id informado
        repository.deleteById(id);
        return ResponseEntity.ok().body("Item deletado com sucesso.");
    }
}
