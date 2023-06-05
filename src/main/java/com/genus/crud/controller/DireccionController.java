package com.genus.crud.controller;

import com.genus.crud.dto.direccion.CreateDireccionDto;
import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.dto.direccion.UpdateDireccionDto;
import com.genus.crud.service.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class DireccionController {

    private final DireccionService direccionService;

    @GetMapping("/direcciones/all")
    public List<DireccionDto> readDireccion(){
        return direccionService.read();
    }

    @PostMapping("/direcciones")
    public DireccionDto createDireccion (@Valid @RequestBody CreateDireccionDto d){
        return direccionService.create(d);
    }

    @PutMapping("/direcciones")
    public DireccionDto updateDireccion(@Valid @RequestBody UpdateDireccionDto d){
        return direccionService.update(d);
    }

    @DeleteMapping("/direcciones/{id}")
    public String deleteDireccion(@PathVariable Long id){
        direccionService.delete(id);
        return "OK";
    }

}
