package com.jonathaneduardo.app.controller;


import com.jonathaneduardo.app.dto.cuentas_bancarias.CuentasBancariasDto;
import com.jonathaneduardo.app.dto.direccion.DireccionDto;
import com.jonathaneduardo.app.dto.persona.CreatePersonaDto;
import com.jonathaneduardo.app.dto.persona.PagePersonaDto;
import com.jonathaneduardo.app.dto.persona.PersonaDto;
import com.jonathaneduardo.app.dto.persona.UpdatePersonaDto;
import com.jonathaneduardo.app.service.PersonaService;
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
@Api(tags = "Persona")
@Tag(name = "Persona", description = "Servicios para las personas")
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping("/persona/all")
    @ApiOperation("Obtiene todas las personas existentes.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public List<PersonaDto> readPersonas(){
        return personaService.read();
    }

    @GetMapping("/persona/{id}")
    @ApiOperation("Obtiene la persona por su id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public PersonaDto obtenerPersonaId(@PathVariable Long id){
        return personaService.findPersonById(id);
    }

    @GetMapping("/persona/{id}/direcciones")
    @ApiOperation("Obtiene las direcciones de una persona por su id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public List<DireccionDto> obtenerDirecciones(@PathVariable Long id) {
        return personaService.findDirecciones(id);
    }

    @GetMapping("/persona/{id}/cuentas")
    @ApiOperation("Obtiene las cuentas bancarias de una persona por su id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public List<CuentasBancariasDto> obtenerCuentas(@PathVariable Long id){
        return personaService.findCuentasBancarias(id);
    }
    @PostMapping("/persona")
    @ApiOperation("Se crea una nueva persona")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public PersonaDto createPersona(@Valid @RequestBody CreatePersonaDto p){
        return personaService.create(p);
    }

    @PutMapping("/persona")
    @ApiOperation("Actualiza una persona.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public PersonaDto updatePersona(@Valid @RequestBody UpdatePersonaDto p){
        return personaService.update(p);
    }

    @DeleteMapping("/persona/{id}")
    @ApiOperation("Elimina una persona por su id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public String deletePersona(@PathVariable Long id){
        personaService.delete(id);
        return "Ok";
    }

    @GetMapping("/persona/byApellidos")
    @ApiOperation("Obtiene una persona por su apellido.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<PagePersonaDto> findByApellido(@RequestParam String apellido, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByApellido(apellido, pagina, tamanio));
    }

    @GetMapping("/persona/byNombres")
    @ApiOperation("Obtiene una persona por su nombre.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<PagePersonaDto> findByNombre(@RequestParam String nombre, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByNombre(nombre, pagina, tamanio));
    }

    @GetMapping("/persona/byNombreApellido")
    @ApiOperation("Obtiene una persona por su nombre y su apellido.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<PagePersonaDto> findByNombreApellido(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByNombreApellido(apellido, nombre, pagina, tamanio));
    }

    @GetMapping("/persona/byCalle")
    @ApiOperation("Obtiene una persona por su calle.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<PagePersonaDto> findByCalle(@RequestParam String calle, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByCalle(calle, pagina, tamanio));
    }

    @GetMapping("/persona/byBancoAsociado")
    @ApiOperation("Obtiene una persona por su banco asociado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<PagePersonaDto> findByBancoAsociado(@RequestParam String banco, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByBancoAsociado(banco, pagina, tamanio));
    }

    @GetMapping("/persona/byUsuario")
    @ApiOperation("Obtiene una persona por su usuario.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<PagePersonaDto> findByUsuario(@RequestParam String user, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByUsuario(user, pagina, tamanio));
    }
}
