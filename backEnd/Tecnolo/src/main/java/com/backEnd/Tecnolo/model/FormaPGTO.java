package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
public class FormaPGTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_forma;

    @Column
    private String tipo;

    @Column
    private Integer parcela;

    @Column
    private Double juros;

    @OneToMany(mappedBy = "id_forma", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"formaPGTO"})

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

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }
}
