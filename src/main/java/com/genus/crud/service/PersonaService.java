package com.genus.crud.service;

import com.genus.crud.dto.cuentas_bancarias.CuentasBancariasDto;
import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.dto.persona.CreatePersonaDto;
import com.genus.crud.dto.persona.PagePersonaDto;
import com.genus.crud.dto.persona.PersonaDto;
import com.genus.crud.dto.persona.UpdatePersonaDto;
import com.genus.crud.entity.Direccion;
import com.genus.crud.entity.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonaService {

    PersonaDto create(CreatePersonaDto p);
    List<PersonaDto> read();
    PersonaDto update(UpdatePersonaDto p);
    void delete(Long id);
    Persona findPersonByIdOrThrow(Long id);
    List<DireccionDto> findDirecciones(Long id);
    PersonaDto findPersonById(Long id);
    List<CuentasBancariasDto> findCuentasBancarias(Long id);
    void guardarImg(MultipartFile file, Long id);
    void actualizarImg(MultipartFile file, Long id);
    String obtenerExtension(String filename);
    void eliminarImg(Long id);
    byte[] obtenerImagen(Long id);
    PagePersonaDto findByApellido(String apellido, Integer pagina, Integer tamanio);
    PagePersonaDto findByNombre(String nombre, Integer pagina, Integer tamanio);
    PagePersonaDto findByNombreApellido(String apellido, String nombre, Integer pagina, Integer tamanio);
    PagePersonaDto findByCalle(String calle, Integer pagina, Integer tamanio);
    PagePersonaDto findByBancoAsociado(String banco, Integer pagina, Integer tamanio);
    PagePersonaDto findByUsuario(String usuario, Integer pagina, Integer tamanio);
}
