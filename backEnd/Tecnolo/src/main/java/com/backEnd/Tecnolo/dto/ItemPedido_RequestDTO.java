package com.backEnd.Tecnolo.dto;

import java.util.Objects;

public class ItemPedido_RequestDTO {
    private Integer item_id;
    private Integer pedido_id;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido_RequestDTO that = (ItemPedido_RequestDTO) o;
        return Objects.equals(item_id, that.item_id) && Objects.equals(pedido_id, that.pedido_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, pedido_id);
    }
}
