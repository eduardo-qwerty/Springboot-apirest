package com.genus.crud.service;

import com.genus.crud.dto.direccion.CreateDireccionDto;
import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.dto.direccion.UpdateDireccionDto;
import com.genus.crud.entity.Direccion;
import com.genus.crud.entity.Persona;
import com.genus.crud.mappers.DireccionMapper;
import com.genus.crud.repository.DireccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService{
    private final DireccionRepository direccionRepository;
    private final DireccionMapper direccionMapper;
    private final PersonaService personaService;

    @Override
    public DireccionDto create(CreateDireccionDto direccion) {
        //Buscar persona en personaService
        Persona p = personaService.findPersonByIdOrThrow(direccion.getPersonaId());
        Direccion d = Direccion.builder()
                .num(direccion.getNum())
                .calle(direccion.getCalle())
                .colonia(direccion.getColonia())
                .codigoPostal(direccion.getCodigoPostal())
                .persona(p)
                .build();
        return direccionMapper.direccionDto(direccionRepository.save(d));
    }

    @Override
    public List<DireccionDto> read() {
        return direccionMapper.listDirectionsDto(direccionRepository.findAll());
    }

    @Override
    public DireccionDto update(UpdateDireccionDto direccion) {
        Direccion d = direccionRepository.findById(direccion.getId()).orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
        d.setNum(direccion.getNum());
        d.setCalle(direccion.getCalle());

        return direccionMapper.direccionDto(direccionRepository.save(d));
    }

    @Override
    public void delete(Long id) {
        Direccion d = direccionRepository.findById(id).orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
        direccionRepository.delete(d);
    }
}
