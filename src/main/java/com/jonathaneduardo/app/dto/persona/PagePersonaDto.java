package com.jonathaneduardo.app.dto.persona;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PagePersonaDto {

    private Long totalElementos;

    private Integer totalPaginas;

    private Integer pageActual;

    private List<PersonaDto> personas;

}
