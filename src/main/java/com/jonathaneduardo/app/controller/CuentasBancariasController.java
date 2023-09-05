package com.jonathaneduardo.app.controller;

import com.jonathaneduardo.app.dto.cuentas_bancarias.CreateCuentasBancariasDto;
import com.jonathaneduardo.app.dto.cuentas_bancarias.CuentasBancariasDto;
import com.jonathaneduardo.app.dto.cuentas_bancarias.UpdateCuentasBancariasDto;
import com.jonathaneduardo.app.service.CuentasBancariasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = "Cuentas bancarias")
@Tag(name = "Cuentas bancarias", description = "Servicios para las cuentas bancarias de la persona")
public class CuentasBancariasController {

    private final CuentasBancariasService cuentasBancariasService;

    @GetMapping("/cuentas/all")
    @ApiOperation("Obtiene todas las cuentas bancarias existentes.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<List<CuentasBancariasDto>> readCuentasBancarias(){
        return ResponseEntity.ok(cuentasBancariasService.read());
    }

    @PostMapping("/cuentas")
    @ApiOperation("Crea una cuenta bancaria.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<CuentasBancariasDto> createCuentasBancariasDto(@Valid @RequestBody CreateCuentasBancariasDto cb){
        return ResponseEntity.ok(cuentasBancariasService.create(cb));
    }

    @PutMapping("/cuentas")
    @ApiOperation("Actualiza una cuenta bancaria.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<CuentasBancariasDto> updaCuentasBancariasDto(@Valid @RequestBody UpdateCuentasBancariasDto cb){
        return ResponseEntity.ok(cuentasBancariasService.update(cb));
    }

    @DeleteMapping("/cuentas/{id}")
    @ApiOperation("Elimina una cuenta bancaria por su id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public String delete(@PathVariable Long id){
        cuentasBancariasService.delete(id);
        return "Ok";
    }

}
