package com.dadyfrancisco.parkapi.park_api.web.controller;

import com.dadyfrancisco.parkapi.park_api.entity.Usuario;
import com.dadyfrancisco.parkapi.park_api.service.UsuarioService;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioCreateDto;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioResponseDto;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioSenhaDto;
import com.dadyfrancisco.parkapi.park_api.web.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto>create(@RequestBody UsuarioCreateDto createDto){
        Usuario user = service.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Long id){
        Usuario user = service.findById(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto>updateSenha(@PathVariable Long id,@RequestBody UsuarioSenhaDto dto){
        Usuario user = service.EditarSenha(id, dto.getSenhaAtual(),dto.getNovaSenha(),dto.getConfiramarSenha());
        return ResponseEntity.noContent().build();

    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> users = service.buscarTodos();
                return ResponseEntity.ok(users);
    }

}
