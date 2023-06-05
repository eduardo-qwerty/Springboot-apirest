package com.genus.crud.controller;


import com.genus.crud.dto.cuentas_bancarias.CuentasBancariasDto;
import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.dto.persona.CreatePersonaDto;
import com.genus.crud.dto.persona.PagePersonaDto;
import com.genus.crud.dto.persona.PersonaDto;
import com.genus.crud.dto.persona.UpdatePersonaDto;
import com.genus.crud.entity.Persona;
import com.genus.crud.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping("/persona/all")
    public List<PersonaDto> readPersonas(){
        return personaService.read();
    }

    @GetMapping("/persona/{id}")
    public PersonaDto obtenerPersonaId(@PathVariable Long id){
        return personaService.findPersonById(id);
    }

    @GetMapping("/persona/{id}/direcciones")
    public List<DireccionDto> obtenerDirecciones(@PathVariable Long id) {
        return personaService.findDirecciones(id);
    }

    @GetMapping("/persona/{id}/cuentas")
    public List<CuentasBancariasDto> obtenerCuentas(@PathVariable Long id){
        return personaService.findCuentasBancarias(id);
    }
    @PostMapping("/persona")
    public PersonaDto createPersona(@Valid @RequestBody CreatePersonaDto p){
        return personaService.create(p);
    }

    @PutMapping("/persona")
    public PersonaDto updatePersona(@Valid @RequestBody UpdatePersonaDto p){
        return personaService.update(p);
    }

    @DeleteMapping("/persona/{id}")
    public String deletePersona(@PathVariable Long id){
        personaService.delete(id);
        return "Ok";
    }

    @GetMapping("/persona/byApellidos")
    public ResponseEntity<PagePersonaDto> findByApellido(@RequestParam String apellido, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByApellido(apellido, pagina, tamanio));
    }

    @GetMapping("/persona/byNombres")
    public ResponseEntity<PagePersonaDto> findByNombre(@RequestParam String nombre, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByNombre(nombre, pagina, tamanio));
    }

    @GetMapping("/persona/byNombreApellido")
    public ResponseEntity<PagePersonaDto> findByNombreApellido(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByNombreApellido(apellido, nombre, pagina, tamanio));
    }

    @GetMapping("/persona/byCalle")
    public ResponseEntity<PagePersonaDto> findByCalle(@RequestParam String calle, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByCalle(calle, pagina, tamanio));
    }

    @GetMapping("/persona/byBancoAsociado")
    public ResponseEntity<PagePersonaDto> findByBancoAsociado(@RequestParam String banco, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByBancoAsociado(banco, pagina, tamanio));
    }

    @GetMapping("/persona/byUsuario")
    public ResponseEntity<PagePersonaDto> findByUsuario(@RequestParam String user, @RequestParam Integer pagina, @RequestParam Integer tamanio){
        return ResponseEntity.ok(personaService.findByUsuario(user, pagina, tamanio));
    }
}
