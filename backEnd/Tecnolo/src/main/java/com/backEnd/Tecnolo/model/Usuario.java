package com.backEnd.Tecnolo.model;

import jakarta.persistence.*;

@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column
    private
}
