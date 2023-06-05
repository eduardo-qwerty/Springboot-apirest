package com.genus.crud.controller;

import com.genus.crud.dto.cuentas_bancarias.CreateCuentasBancariasDto;
import com.genus.crud.dto.cuentas_bancarias.CuentasBancariasDto;
import com.genus.crud.dto.cuentas_bancarias.UpdateCuentasBancariasDto;
import com.genus.crud.dto.direccion.UpdateDireccionDto;
import com.genus.crud.service.CuentasBancariasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class CuentasBancariasController {

    private final CuentasBancariasService cuentasBancariasService;

    @GetMapping("/cuentas/all")
    public List<CuentasBancariasDto> readCuentasBancarias(){
        return cuentasBancariasService.read();
    }

    @PostMapping("/cuentas")
    public CuentasBancariasDto createCuentasBancariasDto(@Valid @RequestBody CreateCuentasBancariasDto cb){
        return cuentasBancariasService.create(cb);
    }

    @PutMapping("/cuentas")
    public CuentasBancariasDto updaCuentasBancariasDto(@Valid @RequestBody UpdateCuentasBancariasDto cb){
        return cuentasBancariasService.update(cb);
    }

    @DeleteMapping("/cuentas/{id}")
    public String delete(@PathVariable Long id){
        cuentasBancariasService.delete(id);
        return "Ok";
    }

}
