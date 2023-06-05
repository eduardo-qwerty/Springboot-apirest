package com.genus.crud.service;

import com.genus.crud.dto.perfil.CreatePerfilDto;
import com.genus.crud.dto.perfil.PerfilDto;
import com.genus.crud.dto.perfil.UpdatePerfilDto;
import com.genus.crud.entity.Perfil;

import java.util.List;

public interface PerfilService {

    Perfil guardar(Perfil p);
}
