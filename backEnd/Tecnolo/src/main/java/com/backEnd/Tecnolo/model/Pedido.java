package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column
    private Double valor;

    @Column
    private Date data_pedido;

    @Column
    private String status;

    @OneToMany(mappedBy = "usuario_id")
    @JsonIgnoreProperties("usuario_id")
    private List<Usuario> usuario;

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

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id_pedido, pedido.id_pedido) && Objects.equals(valor, pedido.valor) && Objects.equals(data_pedido, pedido.data_pedido) && Objects.equals(status, pedido.status) && Objects.equals(usuario, pedido.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pedido, valor, data_pedido, status, usuario);
    }
}
