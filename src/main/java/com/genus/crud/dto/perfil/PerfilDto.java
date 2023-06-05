package com.genus.crud.dto.perfil;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PerfilDto {

    private Long id;
    private String biografia;
    private String usuario;
    private String urlImgPerfil;
    private Integer seguidores;
    private Long personaId;
}
