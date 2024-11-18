package com.backEnd.Tecnolo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

public class ItemPedido {
    @EmbeddedId
    private ItemPedidoPK id;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @JsonIgnoreProperties("pedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_Id", referencedColumnName = "id")
    private Item item;

    // Getters e Setterss

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
