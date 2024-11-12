package com.backEnd.Tecnolo.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

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
    private String atributo1;

    @Column
    private String atributo2;

    @Column
    private String atributo3;

    @Column
    private String atributo4;

    @Column
    private String atributo5;

    @Column
    private String atributo6;

    @Column
    private Integer estoque;

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

    public String getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(String atributo1) {
        this.atributo1 = atributo1;
    }

    public String getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(String atributo2) {
        this.atributo2 = atributo2;
    }

    public String getAtributo3() {
        return atributo3;
    }

    public void setAtributo3(String atributo3) {
        this.atributo3 = atributo3;
    }

    public String getAtributo4() {
        return atributo4;
    }

    public void setAtributo4(String atributo4) {
        this.atributo4 = atributo4;
    }

    public String getAtributo5() {
        return atributo5;
    }

    public void setAtributo5(String atributo5) {
        this.atributo5 = atributo5;
    }

    public String getAtributo6() {
        return atributo6;
    }

    public void setAtributo6(String atributo6) {
        this.atributo6 = atributo6;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id_item, item.id_item) && Objects.equals(nome, item.nome) && Objects.equals(descricao, item.descricao) && Objects.equals(preco, item.preco) && Objects.equals(foto, item.foto) && Objects.equals(atributo1, item.atributo1) && Objects.equals(atributo2, item.atributo2) && Objects.equals(atributo3, item.atributo3) && Objects.equals(atributo4, item.atributo4) && Objects.equals(atributo5, item.atributo5) && Objects.equals(atributo6, item.atributo6) && Objects.equals(estoque, item.estoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_item, nome, descricao, preco, foto, atributo1, atributo2, atributo3, atributo4, atributo5, atributo6, estoque);
    }
}
