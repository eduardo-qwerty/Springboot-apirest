package com.genus.crud.dto.perfil;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePerfilDto {

    @NotNull(message = "El campo id no puede ser nulo")
    private Long id;

    @NotBlank(message = "El campo biografia no puede estar vacío")
    @Size(max = 10, message = "El campo biografia supera el limite permitido")
    private String biografia;

    @Size(max = 50, message = "El campo urlImgPerfil supera el limite permitido")
    private String urlImgPerfil;

    @NotNull(message = "El campo seguidores no puede ser nulo")
    private Integer seguidores;
}
