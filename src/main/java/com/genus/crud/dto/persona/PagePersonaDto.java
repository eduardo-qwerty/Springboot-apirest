package com.genus.crud.dto.persona;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

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
