package com.genus.crud.dto.persona;


import com.genus.crud.dto.perfil.UpdatePerfilDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePersonaDto {

    @NotNull(message = "El campo id es requerido")
    private Long id;

    @NotBlank(message = "El campo es requerido")
    @Size(max = 50, message = "El campo maximo es de 50 letras")
    private String nombre;

    @NotNull(message = "El perfil es requerido")
    private UpdatePerfilDto perfil;

}
