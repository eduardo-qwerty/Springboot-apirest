package com.genus.crud.dto.direccion;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateDireccionDto {

    @NotBlank(message = "El campo num no puede estar vacio")
    @Size(max = 10, message = "El campo num supera el limite permitido")
    private String num;

    @NotBlank(message = "El campo calle no puede estar vacio")
    @Size(max = 50, message = "El campo calle supera el limite permitido")
    private String calle;

    @NotBlank(message = "El campo colonia no puede estar vacio")
    @Size(max = 50, message = "El campo colonia supera el limite permitido")
    private String colonia;

    @NotNull(message = "El campo codigoPostal no puede ser nulo")
    private Integer codigoPostal;

    @NotNull(message = "El campo personaId no puede ser nulo")
    private Long personaId;
}
