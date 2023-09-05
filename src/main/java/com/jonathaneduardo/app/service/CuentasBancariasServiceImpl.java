package com.jonathaneduardo.app.service;

import com.jonathaneduardo.app.dto.cuentas_bancarias.CreateCuentasBancariasDto;
import com.jonathaneduardo.app.dto.cuentas_bancarias.CuentasBancariasDto;
import com.jonathaneduardo.app.dto.cuentas_bancarias.UpdateCuentasBancariasDto;
import com.jonathaneduardo.app.entity.CuentasBancarias;
import com.jonathaneduardo.app.entity.Persona;
import com.jonathaneduardo.app.mappers.CuentasBancariasMapper;
import com.jonathaneduardo.app.repository.CuentasBancariasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentasBancariasServiceImpl implements CuentasBancariasService {

    private final CuentasBancariasRepository cuentasBancariasRepository;
    private final CuentasBancariasMapper cuentasBancariasMapper;
    private final PersonaService personaService;

    @Override
    public CuentasBancariasDto create(CreateCuentasBancariasDto cb) {
        Persona p = personaService.findPersonByIdOrThrow(cb.getPersonaId());
        CuentasBancarias cuenta = CuentasBancarias.builder()
                .saldo(cb.getSaldo())
                .numeroCuenta(cb.getNumeroCuenta())
                .activa(cb.getActiva())
                .bancoAsociado(cb.getBancoAsociado())
                .fechaApertura(cb.getFechaApertura())
                .persona(p)
                .build();
        return cuentasBancariasMapper.cuentasBancariasDto(cuentasBancariasRepository.save(cuenta));
    }

    @Override
    public List<CuentasBancariasDto> read() {
        return cuentasBancariasMapper.listCuentasBancariasDto(cuentasBancariasRepository.findAll());
    }

    @Override
    public CuentasBancariasDto update(UpdateCuentasBancariasDto cb) {
        CuentasBancarias cuenta = cuentasBancariasRepository.findById(cb.getId()).orElseThrow(() ->new RuntimeException("Cuenta bancaria no encontrada"));
        cuenta.setActiva(cb.getActiva());
        cuenta.setSaldo(cb.getSaldo());
        return cuentasBancariasMapper.cuentasBancariasDto(cuentasBancariasRepository.save(cuenta));
    }

    @Override
    public void delete(Long id) {
        CuentasBancarias cb = cuentasBancariasRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta bancario no encontrada"));
        cuentasBancariasRepository.delete(cb);
    }
}
