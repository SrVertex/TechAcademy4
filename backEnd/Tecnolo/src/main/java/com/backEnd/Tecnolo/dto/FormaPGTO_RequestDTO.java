package com.backEnd.Tecnolo.dto;

public class FormaPGTO_RequestDTO {
    private Integer id_forma;
    private String tipo;
    private Integer parcela;
    private Double juros;

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
