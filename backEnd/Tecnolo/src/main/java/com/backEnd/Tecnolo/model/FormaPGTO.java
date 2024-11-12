package com.backEnd.Tecnolo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class FormaPGTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_forma;

    @Column
    private String tipo;

    @Column
    private Integer parcelas;

    @Column
    private Double juros;

    //Getters e Setters

    public Integer getId_forma() {
        return id_forma;
    }

    public void setId_forma(Integer id_forma) {
        this.id_forma = id_forma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPGTO formaPGTO = (FormaPGTO) o;
        return Objects.equals(id_forma, formaPGTO.id_forma) && Objects.equals(tipo, formaPGTO.tipo) && Objects.equals(parcelas, formaPGTO.parcelas) && Objects.equals(juros, formaPGTO.juros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_forma, tipo, parcelas, juros);
    }
}
