package com.jonathaneduardo.app.dto.direccion;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateDireccionDto {

    @NotNull(message = "El campo id no puede ser nulo")
    private Long id;

    @NotBlank(message = "El campo num no puede estar vacío")
    @Size(max = 10, message = "El campo num supera el limite permitido")
    private String num;

    @NotBlank(message = "El campo calle no puede estar vacío")
    @Size(max = 50, message = "El campo calle supera el limite permitido")
    private String calle;

}
