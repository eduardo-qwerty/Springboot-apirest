package com.jonathaneduardo.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, name = "numero_casa", nullable = false)
    private String num;

    @Column(length = 50, name = "calle", nullable = false)
    private String calle;

    @Column(length = 50, name = "colonia", nullable = false)
    private String colonia;

    @Column(length = 50, name = "codigo_postal", nullable = false)
    private Integer codigoPostal;

    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;
}
