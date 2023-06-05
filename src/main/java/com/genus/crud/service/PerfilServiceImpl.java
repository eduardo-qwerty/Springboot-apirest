package com.genus.crud.service;

import com.genus.crud.dto.perfil.CreatePerfilDto;
import com.genus.crud.dto.perfil.PerfilDto;
import com.genus.crud.dto.perfil.UpdatePerfilDto;
import com.genus.crud.entity.Perfil;
import com.genus.crud.entity.Persona;
import com.genus.crud.mappers.PerfilMapper;
import com.genus.crud.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService{

    private final PerfilRepository perfilRepository;

    @Override
    @Transactional
    public Perfil guardar(Perfil p) {
        return perfilRepository.save(p);
    }
}
