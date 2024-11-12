package com.backEnd.Tecnolo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_endereco;

    @Column
    private Integer cep;

    @Column
    private String cidade;

    @Column
    private String uf;

    @Column
    private String bairro;

    @Column
    private String rua;

    @Column
    private Integer numero;

    @Column
    private Integer contato;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Usuario> usuario;

    // Getters e Setters

    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getContato() {
        return contato;
    }

    public void setContato(Integer contato) {
        this.contato = contato;
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
        Endereco endereco = (Endereco) o;
        return Objects.equals(id_endereco, endereco.id_endereco) && Objects.equals(cep, endereco.cep) && Objects.equals(cidade, endereco.cidade) && Objects.equals(uf, endereco.uf) && Objects.equals(bairro, endereco.bairro) && Objects.equals(rua, endereco.rua) && Objects.equals(numero, endereco.numero) && Objects.equals(contato, endereco.contato) && Objects.equals(usuario, endereco.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_endereco, cep, cidade, uf, bairro, rua, numero, contato, usuario);
    }
}
