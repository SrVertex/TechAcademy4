package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;

    @Column
    private String foto;

    @Column
    private String atributo_1;

    @Column
    private String atributo_2;

    @Column
    private String atributo_3;

    @Column
    private String atributo_4;

    @Column
    private String atributo_5;

    @Column
    private String atributo_6;

    @Column
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    @JsonIgnoreProperties("categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "id_item", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("items")


    //Getters e Setters


    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAtributo_1() {
        return atributo_1;
    }

    public void setAtributo_1(String atributo_1) {
        this.atributo_1 = atributo_1;
    }

    public String getAtributo_2() {
        return atributo_2;
    }

    public void setAtributo_2(String atributo_2) {
        this.atributo_2 = atributo_2;
    }

    public String getAtributo_3() {
        return atributo_3;
    }

    public void setAtributo_3(String atributo_3) {
        this.atributo_3 = atributo_3;
    }

    public String getAtributo_4() {
        return atributo_4;
    }

    public void setAtributo_4(String atributo_4) {
        this.atributo_4 = atributo_4;
    }

    public String getAtributo_5() {
        return atributo_5;
    }

    public void setAtributo_5(String atributo_5) {
        this.atributo_5 = atributo_5;
    }

    public String getAtributo_6() {
        return atributo_6;
    }

    public void setAtributo_6(String atributo_6) {
        this.atributo_6 = atributo_6;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}