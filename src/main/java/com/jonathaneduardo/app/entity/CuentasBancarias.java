package com.jonathaneduardo.app.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentasBancarias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, name = "saldo", nullable = false)
    private Double saldo;

    @Column(length = 50, name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @Column(name = "activa", nullable = false)
    private Boolean activa;

    @Column(length = 50, name = "banco_asociado", nullable = false)
    private String bancoAsociado;

    @Column(length = 50, name = "fecha_apertura", nullable = false)
    private LocalDate fechaApertura;

    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;

}
