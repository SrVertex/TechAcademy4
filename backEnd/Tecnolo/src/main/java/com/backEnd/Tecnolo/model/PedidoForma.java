package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pedido_forma")
public class PedidoForma {
    @EmbeddedId
    private PedidoFormaPK id;

    @Column
    private String status;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id", referencedColumnName = "id_pedido")
    @JsonIgnoreProperties("pedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("formaId")
    @JoinColumn(name = "forma_id", referencedColumnName = "id_forma")
    private FormaPGTO formaPGTO;

    // Getters e Setterss




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PedidoFormaPK getId() {
        return id;
    }

    public void setId(PedidoFormaPK id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormaPGTO getFormaPGTO() {
        return formaPGTO;
    }

    public void setFormaPGTO(FormaPGTO formaPGTO) {
        this.formaPGTO = formaPGTO;
    }
}