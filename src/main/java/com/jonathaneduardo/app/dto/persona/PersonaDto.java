package com.jonathaneduardo.app.dto.persona;

import com.jonathaneduardo.app.dto.cuentas_bancarias.CuentasBancariasDto;
import com.jonathaneduardo.app.dto.direccion.DireccionDto;
import com.jonathaneduardo.app.dto.perfil.PerfilDto;
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
