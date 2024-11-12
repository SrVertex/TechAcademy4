package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    @Column
    private String nome;

    @Column
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnoreProperties("categoria")
    private List<Item> item;

    // Getters e Setters

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id_categoria, categoria.id_categoria) && Objects.equals(nome, categoria.nome) && Objects.equals(descricao, categoria.descricao) && Objects.equals(item, categoria.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria, nome, descricao, item);
    }
}
