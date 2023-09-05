package com.jonathaneduardo.app.dto.persona;

import com.jonathaneduardo.app.dto.perfil.CreatePerfilDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreatePersonaDto {

    @NotBlank(message = "El campo es requerido")
    @Size(max = 50, message = "El campo maximo es de 50 letras")
    private String nombre;

    @NotBlank(message = "El campo es requerido")
    @Size(max = 50, message = "El campo maximo es de 50 letras")
    private String apellido;

    @NotNull(message = "El perfil es requerido")
    private CreatePerfilDto perfil;
}
