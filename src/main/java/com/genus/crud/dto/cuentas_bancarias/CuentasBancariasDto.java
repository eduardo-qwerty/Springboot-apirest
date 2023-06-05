package com.genus.crud.dto.cuentas_bancarias;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

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
