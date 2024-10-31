package com.dadyfrancisco.parkapi.park_api.repository;

import com.dadyfrancisco.parkapi.park_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
