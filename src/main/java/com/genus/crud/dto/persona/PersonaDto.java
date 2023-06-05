package com.genus.crud.dto.persona;

import com.genus.crud.dto.cuentas_bancarias.CuentasBancariasDto;
import com.genus.crud.dto.direccion.DireccionDto;
import com.genus.crud.dto.perfil.PerfilDto;
import com.genus.crud.entity.CuentasBancarias;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PersonaDto {

    private Long id;

    private String nombre;

    private String apellido;

    private List<DireccionDto> direcciones;

    private List<CuentasBancariasDto> cuentasBancarias;

    private PerfilDto perfil;

}
