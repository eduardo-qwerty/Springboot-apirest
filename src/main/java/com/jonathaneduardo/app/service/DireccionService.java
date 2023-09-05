package com.jonathaneduardo.app.service;

import com.jonathaneduardo.app.dto.direccion.CreateDireccionDto;
import com.jonathaneduardo.app.dto.direccion.DireccionDto;
import com.jonathaneduardo.app.dto.direccion.UpdateDireccionDto;

import java.util.List;

public interface DireccionService {
    DireccionDto create(CreateDireccionDto d);
    List<DireccionDto> read();
    DireccionDto update(UpdateDireccionDto d);
    void delete(Long id);
}

