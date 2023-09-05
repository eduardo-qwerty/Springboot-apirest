package com.jonathaneduardo.app.controller;

import com.jonathaneduardo.app.dto.direccion.CreateDireccionDto;
import com.jonathaneduardo.app.dto.direccion.DireccionDto;
import com.jonathaneduardo.app.dto.direccion.UpdateDireccionDto;
import com.jonathaneduardo.app.service.DireccionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = "Direcciones")
@Tag(name = "Direcciones", description = "Servicios para las direcciones de la persona")
public class DireccionController {

    private final DireccionService direccionService;

    @GetMapping("/direcciones/all")
    @ApiOperation("Obtiene todas las direcciones existentes.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public List<DireccionDto> readDireccion(){
        return direccionService.read();
    }

    @PostMapping("/direcciones")
    @ApiOperation("Crea una dirección.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public DireccionDto createDireccion (@Valid @RequestBody CreateDireccionDto d){
        return direccionService.create(d);
    }

    @PutMapping("/direcciones")
    @ApiOperation("Actualiza una dirección.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public DireccionDto updateDireccion(@Valid @RequestBody UpdateDireccionDto d){
        return direccionService.update(d);
    }

    @DeleteMapping("/direcciones/{id}")
    @ApiOperation("Elimina una dirección.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public String deleteDireccion(@PathVariable Long id){
        direccionService.delete(id);
        return "OK";
    }

}
