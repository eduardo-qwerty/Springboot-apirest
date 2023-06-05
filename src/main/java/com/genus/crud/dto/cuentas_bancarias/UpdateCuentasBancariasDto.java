package com.genus.crud.dto.cuentas_bancarias;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateCuentasBancariasDto {

    @NotNull(message = "El campo id no pude ser nulo")
    private Long id;

    @NotNull(message = "El campo saldo no puede ser nulo")
    private Double saldo;

    @NotNull(message = "El campo estadoCuenta no puede ser nulo")
    private Boolean activa;
}
