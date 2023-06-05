package com.genus.crud.service;

import com.genus.crud.dto.cuentas_bancarias.CuentasBancariasDto;
import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.dto.perfil.CreatePerfilDto;
import com.genus.crud.dto.persona.CreatePersonaDto;
import com.genus.crud.dto.persona.PagePersonaDto;
import com.genus.crud.dto.persona.PersonaDto;
import com.genus.crud.dto.persona.UpdatePersonaDto;
import com.genus.crud.entity.CuentasBancarias;
import com.genus.crud.entity.Direccion;
import com.genus.crud.entity.Perfil;
import com.genus.crud.entity.Persona;
import com.genus.crud.mappers.CuentasBancariasMapper;
import com.genus.crud.mappers.DireccionMapper;
import com.genus.crud.mappers.PerfilMapper;
import com.genus.crud.mappers.PersonaMapper;
import com.genus.crud.repository.DireccionRepository;
import com.genus.crud.repository.PersonaRepository;
import com.genus.crud.utils.Archivo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    private String rutaImagenes = "src//main//java//com//genus//crud//utils//imagenes//";
    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;
    private final DireccionMapper direccionMapper;
    private final CuentasBancariasMapper cuentasBancariasMapper;
    private final DireccionRepository direccionRepository;
    private final PerfilService perfilService;

    @Override
    @Transactional
    public PersonaDto create(CreatePersonaDto persona) {
        // Se crea la persona base
        Persona personaTemp = Persona.builder()
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .build();
        //Se guarda la persona base
        Persona p2 = personaRepository.save(personaTemp);
        //Se obtiene el perfil de la persona parametro
        CreatePerfilDto perfilDto = persona.getPerfil();
        //Se crea un perfil con los datos
        Perfil perfil = new Perfil();
        perfil.setBiografia(perfilDto.getBiografia());
        perfil.setUsuario(perfilDto.getUsuario());
        perfil.setUrlImgPerfil(perfilDto.getUrlImgPerfil());
        perfil.setSeguidores(perfilDto.getSeguidores());
        perfil.setPersona(p2); //se le pasa la persona base
        perfilService.guardar(perfil); //se guarda el perfil
        //Se actualizan los datos del perfil de la persona
        personaTemp.setPerfil(perfil);
        personaTemp.setListaDirecciones(new ArrayList<>()); //En caso de que la lista de direcciones este vacia
        personaTemp.setListaCuentasBancarias(new ArrayList<>());
        return personaMapper.personaDto(personaTemp);
    }

    @Override
    public List<PersonaDto> read() {
        return personaMapper.listPersonasDto(personaRepository.findAll());
    }

    @Override
    public PersonaDto update(UpdatePersonaDto persona) {
        Persona p = findPersonByIdOrThrow(persona.getId());
        p.setNombre(persona.getNombre());
        p.getPerfil().setBiografia(persona.getPerfil().getBiografia());
        p.getPerfil().setUrlImgPerfil(persona.getPerfil().getUrlImgPerfil());
        p.getPerfil().setSeguidores(persona.getPerfil().getSeguidores());
        return personaMapper.personaDto(personaRepository.save(p));
    }

    @Override
    public void delete(Long id) {
        Persona persona = findPersonByIdOrThrow(id);
        personaRepository.delete(persona);
    }

    @Override
    public Persona findPersonByIdOrThrow(Long id) {
        return personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Override
    public List<DireccionDto> findDirecciones(Long id) {
        Persona persona = findPersonByIdOrThrow(id);
        List<Direccion> direcciones = persona.getListaDirecciones();
        return direccionMapper.listDirectionsDto(direcciones);
    }

    @Override
    public PersonaDto findPersonById(Long id) {
        Persona persona = findPersonByIdOrThrow(id);
        return personaMapper.personaDto(persona);
    }

    @Override
    public List<CuentasBancariasDto> findCuentasBancarias(Long id) {
        Persona persona = findPersonByIdOrThrow(id);
        List<CuentasBancarias> cuentas = persona.getListaCuentasBancarias();
        return cuentasBancariasMapper.listCuentasBancariasDto(cuentas);
    }

    @Override
    public void guardarImg(MultipartFile file, Long id) {
        String extension = obtenerExtension(file.getOriginalFilename());
        if (extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg")) {
            Persona p = findPersonByIdOrThrow(id);
            p.getPerfil().setUrlImgPerfil(id +"@"+ file.getOriginalFilename());
            personaRepository.save(p);
            String uploadDir = rutaImagenes + id +"@"+  file.getOriginalFilename();
            Archivo.saveFile(file, uploadDir);
        } else {
            throw new IllegalArgumentException("El formato de archivo no es válido");
        }
    }

    @Override
    public void actualizarImg(MultipartFile file, Long id) {
       this.eliminarImg(id);
       this.guardarImg(file, id);
    }


    @Override
    public String obtenerExtension(String filename) {
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }

    @Override
    public void eliminarImg(Long id) {
        Persona p = findPersonByIdOrThrow(id);
        String img = p.getPerfil().getUrlImgPerfil();
        p.getPerfil().setUrlImgPerfil(null);
        personaRepository.save(p);
        String uploadDir = rutaImagenes;
        File file = new File(uploadDir + img);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public byte[] obtenerImagen(Long id) {
        try {
            Persona p = findPersonByIdOrThrow(id);
            String img = p.getPerfil().getUrlImgPerfil();
            if(img != null){
                return Archivo.getArchivo(rutaImagenes + img);
            } else {
                throw new RuntimeException("La imagen es nula");
            }
        } catch (IOException e) {
            throw new Error("Ocurrio un error al obtener la imagen");
        }
    }

    @Override
    public PagePersonaDto findByApellido(String apellido, Integer pagina, Integer tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("apellido").ascending());
        Page<Persona> page = personaRepository.findByApellidoContainingAllIgnoreCase(apellido, pageable);
        List<PersonaDto> personaDtos = personaMapper.listPersonasDto(page.getContent());
        //return personaMapper.listPersonasDto(personaRepository.findByApellidoContaining(apellido));
        return PagePersonaDto.builder()
                .totalElementos(page.getTotalElements())
                .totalPaginas(page.getTotalPages())
                .pageActual(page.getNumber())
                .personas(personaDtos)
                .build();
    }



    @Override
    public PagePersonaDto findByNombreApellido(String apellido, String nombre , Integer pagina, Integer tamanio) {
        //return personaMapper.listPersonasDto(personaRepository.findByApellidoAndNombreAllIgnoreCase(apellido, nombre));
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("apellido","nombre").ascending());
        Page<Persona> page = personaRepository.findByApellidoAndNombreContainingAllIgnoreCase(apellido, nombre, pageable);
        List<PersonaDto> personaDtos = personaMapper.listPersonasDto(page.getContent());
        return PagePersonaDto.builder()
                .totalElementos(page.getTotalElements())
                .totalPaginas(page.getTotalPages())
                .pageActual(page.getNumber())
                .personas(personaDtos)
                .build();
    }

    @Override
    public PagePersonaDto findByNombre(String nombre, Integer pagina, Integer tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("nombre").ascending());
        Page<Persona> page = personaRepository.findByNombreContainingAllIgnoreCase(nombre, pageable);
        List<PersonaDto> personaDtos = personaMapper.listPersonasDto(page.getContent());
        return PagePersonaDto.builder()
                .totalElementos(page.getTotalElements())
                .totalPaginas(page.getTotalPages())
                .pageActual(page.getNumber())
                .personas(personaDtos)
                .build();
    }

    @Override
    public PagePersonaDto findByCalle(String calle, Integer pagina, Integer tamanio) {
        //return personaMapper.listPersonasDto(personaRepository.findByListaDireccionesCalle(calle));
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("nombre").ascending());
        Page<Persona> page = personaRepository.findByCalle(calle, pageable);
        List<PersonaDto> personaDtos = personaMapper.listPersonasDto(page.getContent());
        return PagePersonaDto.builder()
                .totalElementos(page.getTotalElements())
                .totalPaginas(page.getTotalPages())
                .pageActual(page.getNumber())
                .personas(personaDtos)
                .build();
    }

    @Override
    public PagePersonaDto findByBancoAsociado(String banco, Integer pagina, Integer tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("nombre").ascending());
        Page<Persona> page = personaRepository.findByBanco(banco, pageable);
        //Page<Persona> page = personaRepository.findBylistaCuentasBancariasBancoAsociadoContainingAllIgnoreCase(banco, pageable);
        List<PersonaDto> personaDtos = personaMapper.listPersonasDto(page.getContent());
        return PagePersonaDto.builder()
                .totalElementos(page.getTotalElements())
                .totalPaginas(page.getTotalPages())
                .pageActual(page.getNumber())
                .personas(personaDtos)
                .build();
    }

    @Override
    public PagePersonaDto findByUsuario(String usuario, Integer pagina, Integer tamanio) {
        Pageable pageable = PageRequest.of(pagina, tamanio, Sort.by("nombre").ascending());
        Page<Persona> page = personaRepository.findByUsuario(usuario, pageable);
        //Page<Persona> page = personaRepository.findBylistaCuentasBancariasBancoAsociadoContainingAllIgnoreCase(banco, pageable);
        List<PersonaDto> personaDtos = personaMapper.listPersonasDto(page.getContent());
        return PagePersonaDto.builder()
                .totalElementos(page.getTotalElements())
                .totalPaginas(page.getTotalPages())
                .pageActual(page.getNumber())
                .personas(personaDtos)
                .build();
    }
}
