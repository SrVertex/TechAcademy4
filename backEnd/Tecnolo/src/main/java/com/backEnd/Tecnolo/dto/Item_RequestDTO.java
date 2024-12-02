package com.backEnd.Tecnolo.dto;
    public class Item_RequestDTO{
        private Integer id_item;
        private String nome;
        private String descricao;
        private Double preco;
        private String foto;
        private String atributo_1;
        private String atributo_2;
        private String atributo_3;
        private String atributo_4;
        private String atributo_5;
        private String atributo_6;
        private Integer estoque;
        private Integer categoria_id;

        public Integer getId_item() {
            return id_item;
        }

        public void setId_item(Integer id_item) {
            this.id_item = id_item;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
        }

        public String getAtributo_1() {
            return atributo_1;
        }

        public void setAtributo_1(String atributo_1) {
            this.atributo_1 = atributo_1;
        }

        public String getAtributo_2() {
            return atributo_2;
        }

        public void setAtributo_2(String atributo_2) {
            this.atributo_2 = atributo_2;
        }

        public String getAtributo_3() {
            return atributo_3;
        }

        public void setAtributo_3(String atributo_3) {
            this.atributo_3 = atributo_3;
        }

        public String getAtributo_4() {
            return atributo_4;
        }

        public void setAtributo_4(String atributo_4) {
            this.atributo_4 = atributo_4;
        }

        public String getAtributo_5() {
            return atributo_5;
        }

        public void setAtributo_5(String atributo_5) {
            this.atributo_5 = atributo_5;
        }

        public String getAtributo_6() {
            return atributo_6;
        }

        public void setAtributo_6(String atributo_6) {
            this.atributo_6 = atributo_6;
        }

        public Integer getEstoque() {
            return estoque;
        }

        public void setEstoque(Integer estoque) {
            this.estoque = estoque;
        }

        public Integer getCategoria_id() {
            return categoria_id;
        }

        public void setCategoria_id(Integer categoria_id) {
            this.categoria_id = categoria_id;
        }
    }
