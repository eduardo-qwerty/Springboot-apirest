package com.genus.crud.controller;

import com.genus.crud.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class PerfilController {
    private final PersonaService personaService;

    //GET
    //return new ResponseEntity[bytes]

    @GetMapping("perfil/{id}/imgPerfil")
    public ResponseEntity<byte[]> obtenerImg(@PathVariable Long id){
        byte[] imageData = personaService.obtenerImagen(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
    }



    @PostMapping("perfil/{id}/imgPerfil")
    public ResponseEntity<String> saveImg(@PathVariable Long id, @RequestParam("archivo") MultipartFile archivo){
        personaService.guardarImg(archivo, id);
        return new ResponseEntity<>("Imagen guardada.", HttpStatus.CREATED);
    }

    @PutMapping("perfil/{id}/imgPerfil")
    public ResponseEntity<String> uploadImg(@PathVariable Long id, @RequestParam("archivo") MultipartFile archivo){
        personaService.actualizarImg(archivo, id);
        return new ResponseEntity<>("Imagen actualizada.", HttpStatus.CREATED);
    }

    @DeleteMapping("perfil/{id}/imgPerfil")
    public ResponseEntity<String> deleteImg(@PathVariable Long id){
        personaService.eliminarImg(id);
        return new ResponseEntity<>("Imagen eliminada.", HttpStatus.OK);
    }
}
