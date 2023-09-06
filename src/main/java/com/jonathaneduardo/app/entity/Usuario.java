package com.jonathaneduardo.app.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    private String nombre;
    private String email;
    private String password;
}
