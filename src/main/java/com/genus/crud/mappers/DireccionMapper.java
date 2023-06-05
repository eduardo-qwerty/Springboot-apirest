package com.genus.crud.mappers;

import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.entity.Direccion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DireccionMapper {

    public DireccionDto direccionDto(Direccion d){
        return DireccionDto.builder()
                .id(d.getId())
                .num(d.getNum())
                .calle(d.getCalle())
                .colonia(d.getColonia())
                .codigoPostal(d.getCodigoPostal())
                .personaId(d.getPersona().getId())
                .build();
    }

    public List<DireccionDto> listDirectionsDto(List<Direccion> ld){
        System.out.println("Cantidad: " + ld.size());
        return ld.stream().map((dir)->this.direccionDto(dir)).collect(Collectors.toList());
    }
}
