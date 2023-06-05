package com.genus.crud.service;

import com.genus.crud.dto.cuentas_bancarias.CreateCuentasBancariasDto;
import com.genus.crud.dto.cuentas_bancarias.CuentasBancariasDto;
import com.genus.crud.dto.cuentas_bancarias.UpdateCuentasBancariasDto;

import java.util.List;

public interface CuentasBancariasService {
    CuentasBancariasDto create(CreateCuentasBancariasDto cb);
    List<CuentasBancariasDto> read();
    CuentasBancariasDto update(UpdateCuentasBancariasDto cb);
    void delete(Long id);
}
