package com.jonathaneduardo.app.controller;

import com.jonathaneduardo.app.service.PersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = "Perfil")
@Tag(name = "Perfil", description = "Servicios para el perfil de la persona")
public class PerfilController {


    private final PersonaService personaService;

    @GetMapping("perfil/{id}/imgPerfil")
    @ApiOperation("Obtiene la imagen de un perfil por su id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<byte[]> obtenerImg(@PathVariable Long id){
        byte[] imageData = personaService.obtenerImagen(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
    }


    @PostMapping("perfil/{id}/imgPerfil")
    @ApiOperation("Guarda una imagen en un perfil.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<String> saveImg(@PathVariable Long id, @RequestParam("archivo") MultipartFile archivo){
        personaService.guardarImg(archivo, id);
        return new ResponseEntity<>("Imagen guardada.", HttpStatus.CREATED);
    }

    @PutMapping("perfil/{id}/imgPerfil")
    @ApiOperation("Actualiza la imagen de un perfil.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<String> uploadImg(@PathVariable Long id, @RequestParam("archivo") MultipartFile archivo){
        personaService.actualizarImg(archivo, id);
        return new ResponseEntity<>("Imagen actualizada.", HttpStatus.CREATED);
    }

    @DeleteMapping("perfil/{id}/imgPerfil")
    @ApiOperation("Elimina la imagen de un perfil.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud se ha completado exitosamente."),
            @ApiResponse(code = 400, message = "La solicitud del cliente es incorrecta"),
            @ApiResponse(code = 401, message = "Acceso no autorizado. Proporcione credenciales válidas."),
            @ApiResponse(code = 403, message = "Acceso prohibido. No tiene los permisos necesarios."),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado."),
            @ApiResponse(code = 500, message = "Ocurrió un error interno en el servidor.")
    })
    public ResponseEntity<String> deleteImg(@PathVariable Long id){
        personaService.eliminarImg(id);
        return new ResponseEntity<>("Imagen eliminada.", HttpStatus.OK);
    }
}
