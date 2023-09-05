package com.jonathaneduardo.app.dto.cuentas_bancarias;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CuentasBancariasDto {

    private Long id;

    private Double saldo;

    private Boolean activa;

    private String bancoAsociado;

    private LocalDate fechaApertura;

    private Long personaId;

}
