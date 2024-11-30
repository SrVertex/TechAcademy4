package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Embeddable
public class PedidoFormaPK {

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "forma_id")
    private Integer formaId;

    // Getters e Setterss

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getFormaId() {
        return formaId;
    }

    public void setFormaId(Integer formaId) {
        this.formaId = formaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoFormaPK that = (PedidoFormaPK) o;
        return Objects.equals(pedidoId, that.pedidoId) && Objects.equals(formaId, that.formaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, formaId);
    }
}