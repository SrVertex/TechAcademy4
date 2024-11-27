package com.backEnd.Tecnolo.dto;

import java.nio.charset.CodingErrorAction;

public class PedidoForma_RequestDTO {

    private Integer pedido_id;
    private Integer forma_id;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Integer getForma_id() {
        return forma_id;
    }

    public void setForma_id(Integer forma_id) {
        this.forma_id = forma_id;
    }
}
