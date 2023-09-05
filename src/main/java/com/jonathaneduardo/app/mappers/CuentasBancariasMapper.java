package com.jonathaneduardo.app.mappers;


import com.jonathaneduardo.app.dto.cuentas_bancarias.CuentasBancariasDto;
import com.jonathaneduardo.app.entity.CuentasBancarias;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CuentasBancariasMapper {

    /**
     * Convierte una cuenta bancaria de tipo <code>CuentasBancarias</code> a tipo <code>CuentasBancariasDto</code>
     *
     * @param cb    cuenta bancaria de tipo <code>CuentasBancarias</code>
     * @return  regresa una cuenta bancaria de tipo <code>CuentasBancariasDto</code>
     */
    public CuentasBancariasDto cuentasBancariasDto(CuentasBancarias cb){
        return CuentasBancariasDto.builder()
                .id(cb.getId())
                .saldo(cb.getSaldo())
                .activa(cb.getActiva())
                .bancoAsociado(cb.getBancoAsociado())
                .fechaApertura(cb.getFechaApertura())
                .personaId(cb.getPersona().getId())
                .build();
    }

    /**
     * Convierte una lista de tipo <code>CuentasBancarias</code> en tipo <code>CuentasBancariasDto</code>
     *
     * @param lcb lista de tipo <code>CuentasBancarias</code>
     * @return  regresa una lista de tipo <code>CuentasBancariasDto</code>
     */
    public List<CuentasBancariasDto> listCuentasBancariasDto(List<CuentasBancarias> lcb){
        return lcb.stream().map((cuenta) -> this.cuentasBancariasDto(cuenta)).collect(Collectors.toList());
    }

}
