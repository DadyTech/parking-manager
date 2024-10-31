package com.dadyfrancisco.parkapi.park_api.service;

import com.dadyfrancisco.parkapi.park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final  UsuarioRepository repository;
}
