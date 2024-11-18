package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column
    private Double valor;

    @Column
    private Timestamp data_pedido;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"usuarios"})
    private Usuario usuario;

    @OneToMany(mappedBy = "id_pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"pedidos"})



    // Getters e Setters


    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Timestamp getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Timestamp data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
