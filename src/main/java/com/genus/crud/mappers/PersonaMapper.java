package com.genus.crud.mappers;

import com.genus.crud.dto.persona.PersonaDto;
import com.genus.crud.entity.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonaMapper {

    private final DireccionMapper direccionMapper;
    private final CuentasBancariasMapper cuentasBancariasMapper;

    private final PerfilMapper perfilMapper;

    public PersonaDto personaDto(Persona p){
        return PersonaDto.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .apellido(p.getApellido())
                .direcciones(direccionMapper.listDirectionsDto(p.getListaDirecciones()))
                .cuentasBancarias(cuentasBancariasMapper.listCuentasBancariasDto(p.getListaCuentasBancarias()))
                .perfil(perfilMapper.perfilDto(p.getPerfil()))
                .build();
    }

    /**
     * Encargado de convertir una lista de <code>Persona</code> en <code>PersonaDto</code>
     *
     * @param personas
     * @return
     */
    public List<PersonaDto> listPersonasDto(List<Persona> personas){
        //por referencia:
        // return personas.stream().map(this::personaDto).collect(Collectors.toList());
        //expresion lambda:
        return personas.stream().map((p)-> this.personaDto(p)).collect(Collectors.toList());
    }



}
