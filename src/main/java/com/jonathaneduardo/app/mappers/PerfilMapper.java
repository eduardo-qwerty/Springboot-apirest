package com.jonathaneduardo.app.mappers;

import com.jonathaneduardo.app.dto.perfil.PerfilDto;
import com.jonathaneduardo.app.entity.Perfil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PerfilMapper {

    public PerfilDto perfilDto(Perfil p){
        return PerfilDto.builder()
                .id(p.getId())
                .biografia(p.getBiografia())
                .usuario(p.getUsuario())
                .urlImgPerfil(p.getUrlImgPerfil())
                .seguidores(p.getSeguidores())
                .personaId(p.getPersona().getId())
                .build();
    }

    public List<PerfilDto> listPerfilDto(List<Perfil> perfils){
        return perfils.stream().map((p)->this.perfilDto(p)).collect(Collectors.toList());
    }
}
