package com.dadyfrancisco.parkapi.park_api.service;

import com.dadyfrancisco.parkapi.park_api.entity.Usuario;
import com.dadyfrancisco.parkapi.park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final  UsuarioRepository repository;
    @Transactional
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);

    }
}
