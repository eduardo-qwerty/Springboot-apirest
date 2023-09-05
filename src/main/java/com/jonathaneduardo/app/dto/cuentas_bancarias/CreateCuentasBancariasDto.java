package com.jonathaneduardo.app.dto.cuentas_bancarias;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class CreateCuentasBancariasDto {

    @NotNull(message = "El campo saldo no puede ser nulo")
    private Double saldo;

    @NotBlank(message = "El campo numeroCuenta no puede estar vacío")
    @Size(max = 50, message = "El campo numeroCuenta supera el limite permitido")
    private String numeroCuenta;

    @NotNull(message = "El campo activa no puede ser nulo")
    private Boolean activa;

    @NotBlank(message = "El campo bancoAsociado no puede estar vacío")
    @Size(max = 50, message = "El campo bancoAsociado supera el limite permitido")
    private String bancoAsociado;

    @NotNull(message = "El campo fechaApertura no puede ser nulo")
    private LocalDate fechaApertura;

    @NotNull(message = "El campo personaId no puede ser nulo")
    private Long personaId;
}
