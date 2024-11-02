package com.dadyfrancisco.parkapi.park_api.service;

import com.dadyfrancisco.parkapi.park_api.entity.Usuario;
import com.dadyfrancisco.parkapi.park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final  UsuarioRepository repository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);

    }
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
    }
    @Transactional
    public Usuario EditarSenha(Long id, String senhaAtual, String novaSenha, String confiramarSenha) {
        if (!novaSenha.equals(confiramarSenha)){
           throw  new RuntimeException("Nova senha nao confere com confirmar senha");
        }
        Usuario user = findById(id);
        if (!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException(" senha nao confere. ");
        }
        user.setPassword(novaSenha);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }
}
