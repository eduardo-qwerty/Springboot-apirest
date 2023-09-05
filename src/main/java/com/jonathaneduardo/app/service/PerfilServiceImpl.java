package com.jonathaneduardo.app.service;

import com.jonathaneduardo.app.entity.Perfil;
import com.jonathaneduardo.app.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService{

    private final PerfilRepository perfilRepository;

    @Override
    @Transactional
    public Perfil guardar(Perfil p) {
        return perfilRepository.save(p);
    }
}
