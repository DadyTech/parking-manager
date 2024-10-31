package com.dadyfrancisco.parkapi.park_api.web.controller;

import com.dadyfrancisco.parkapi.park_api.entity.Usuario;
import com.dadyfrancisco.parkapi.park_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario>create(@RequestBody Usuario usuario){
        Usuario user = service.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        Usuario user = service.findById(id);
        return ResponseEntity.ok(user);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario>updateSenha(@PathVariable Long id,@RequestBody Usuario usuario){
        Usuario user = service.EditarSenha(id,usuario.getPassword());
        return ResponseEntity.ok(user);

    }

}
