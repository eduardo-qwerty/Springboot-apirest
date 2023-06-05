package com.genus.crud.service;

import com.genus.crud.dto.direccion.CreateDireccionDto;
import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.dto.direccion.UpdateDireccionDto;
import com.genus.crud.dto.persona.UpdatePersonaDto;
import com.genus.crud.entity.Direccion;
import com.genus.crud.entity.Persona;

import java.util.List;

public interface DireccionService {
    DireccionDto create(CreateDireccionDto d);
    List<DireccionDto> read();
    DireccionDto update(UpdateDireccionDto d);
    void delete(Long id);
}

