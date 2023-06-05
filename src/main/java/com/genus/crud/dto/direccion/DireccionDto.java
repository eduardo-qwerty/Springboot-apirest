package com.genus.crud.dto.direccion;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DireccionDto {

    private Long id;

    private String num;

    private String calle;

    private String colonia;

    private Integer codigoPostal;

    private Long personaId;

}
