package com.jonathaneduardo.app.entity;

import lombok.*;

import javax.persistence.*;

/**
 * entidad perfil (biografia, usuario, url:imagendeperfil, integer:seguidores) 1:1
 *  one to one
 */

@Entity
@Table(name = "perfil")
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String biografia;

    @Column(length = 50, nullable = false)
    private String usuario;

    @Column(length = 50)
    private String urlImgPerfil;

    @Column(length = 50)
    private Integer seguidores;

    @OneToOne(fetch = FetchType.LAZY)
    private Persona persona;
}
