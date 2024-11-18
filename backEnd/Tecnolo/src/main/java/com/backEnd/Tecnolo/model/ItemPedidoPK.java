package com.backEnd.Tecnolo.model;

import jakarta.persistence.Column;

import java.util.Objects;

public class ItemPedidoPK {
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "item_id")
    private Integer itemId;

    // Getters e Setterss


    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return Objects.equals(pedidoId, that.pedidoId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, itemId);
    }
}