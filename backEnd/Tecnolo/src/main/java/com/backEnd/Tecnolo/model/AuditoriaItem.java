package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class AuditoriaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_auditoria;

    @Column
    private Date data;

    @Column
    private Double preco_antigo;

    @Column
    private Double preco_novo;

    @Column
    private String motivo;

    @OneToMany(mappedBy = "item_id")
    @JsonIgnoreProperties("item_id")
    private List<Item> item_id;

    // Getters e Setters

    public Integer getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(Integer id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getPreco_antigo() {
        return preco_antigo;
    }

    public void setPreco_antigo(Double preco_antigo) {
        this.preco_antigo = preco_antigo;
    }

    public Double getPreco_novo() {
        return preco_novo;
    }

    public void setPreco_novo(Double preco_novo) {
        this.preco_novo = preco_novo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<Item> getItem_id() {
        return item_id;
    }

    public void setItem_id(List<Item> item_id) {
        this.item_id = item_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditoriaItem that = (AuditoriaItem) o;
        return Objects.equals(id_auditoria, that.id_auditoria) && Objects.equals(data, that.data) && Objects.equals(preco_antigo, that.preco_antigo) && Objects.equals(preco_novo, that.preco_novo) && Objects.equals(motivo, that.motivo) && Objects.equals(item_id, that.item_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_auditoria, data, preco_antigo, preco_novo, motivo, item_id);
    }
}
