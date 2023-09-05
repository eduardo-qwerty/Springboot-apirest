package com.jonathaneduardo.app.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "persona")
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<Direccion> listaDirecciones;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    private List<CuentasBancarias> listaCuentasBancarias;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    private Perfil perfil;

}
