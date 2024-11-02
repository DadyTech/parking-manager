package com.dadyfrancisco.parkapi.park_api.web.dto.mapper;

import com.dadyfrancisco.parkapi.park_api.entity.Usuario;
import com.dadyfrancisco.parkapi.park_api.repository.UsuarioRepository;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioCreateDto;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {


   /*public static Usuario toUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto,Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario){
        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Usuario,UsuarioResponseDto>props  = new PropertyMap<Usuario, UsuarioResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
         ModelMapper mapper =  new ModelMapper();
         mapper.addMappings(props);
         return mapper.map(usuario, UsuarioResponseDto.class);
    }*/

    private final  UsuarioRepository repository;
    @Autowired
    public UsuarioMapper(UsuarioRepository repository) {
        this.repository = repository;
    }

     public static Usuario toUsuario(UsuarioCreateDto createDto){
        Usuario usuario = new Usuario();
        usuario.setUsername(createDto.getUsername());
        usuario.setPassword(createDto.getPassword());
        return usuario;
    }

    public static UsuarioResponseDto toDto(Usuario usuario){
        UsuarioResponseDto responseDto = new UsuarioResponseDto();
        responseDto.setId(usuario.getId());
        responseDto.setUsername(usuario.getUsername());
        String role = usuario.getRole().name().substring("ROLE_".length());
        responseDto.setRole(role);
        return responseDto;
    }

    public static List<UsuarioResponseDto> toall(List<Usuario> usuarios){
        return usuarios.stream().map(user ->toDto(user)).collect(Collectors.toList());
    }


}
