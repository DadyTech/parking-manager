package com.dadyfrancisco.parkapi.park_api.web.controller;

import com.dadyfrancisco.parkapi.park_api.entity.Usuario;
import com.dadyfrancisco.parkapi.park_api.service.UsuarioService;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioCreateDto;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioResponseDto;
import com.dadyfrancisco.parkapi.park_api.web.dto.UsuarioSenhaDto;
import com.dadyfrancisco.parkapi.park_api.web.dto.mapper.UsuarioMapper;
import com.dadyfrancisco.parkapi.park_api.web.exception.ErroMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Usuarios",description = "Contem todas as operacoes relativos aos recursos para cadastrar, edicao e leitura de um usuario")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @Operation(
            summary = "Criar um novo usuario",description = "Recurso para criar um novo usuario",
            responses = {
                    @ApiResponse(responseCode = "201",description = "Recursos com sucesso",
                             content = @Content(mediaType ="application/json",schema = @Schema(implementation = UsuarioResponseDto.class))),
                    @ApiResponse(responseCode = "409",description = "Usuario e-mail já cadastrado no sistema",
                             content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErroMessage.class))),
                    @ApiResponse(responseCode = "422",description = "Recursos nao processada por dados de entrada invalidos",
                             content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErroMessage.class)))
            }
    )
    @PostMapping
    public ResponseEntity<UsuarioResponseDto>create(@Valid @RequestBody UsuarioCreateDto createDto){
        Usuario user = service.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }


    @Operation(
            summary = "Recuperar um Usuario pelo Id",description = "Recuperar um usuario pelo Id",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Recursos com sucesso",
                            content = @Content(mediaType ="application/json",schema = @Schema(implementation = UsuarioResponseDto.class))),
                    @ApiResponse(responseCode = "404",description = "Recursos nao em contrado",
                            content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErroMessage.class))),

            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Long id){
        Usuario user = service.findById(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @Operation(
            summary = "Atualizar senha",description = "Atualizar senha",
            responses = {
                    @ApiResponse(responseCode = "204",description = "Atualizar senha com sucesso",
                            content = @Content(mediaType ="application/json",schema = @Schema(implementation = Void.class))),
                    @ApiResponse(responseCode = "404",description = "Recursos nao em contrado",
                            content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErroMessage.class))),
                    @ApiResponse(responseCode = "400",description = "Senhas nao confere",
                            content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErroMessage.class)))

            }
    )
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto>updateSenha(@Valid @PathVariable Long id,@RequestBody UsuarioSenhaDto dto){
        Usuario user = service.EditarSenha(id, dto.getSenhaAtual(),dto.getNovaSenha(),dto.getConfiramarSenha());
        return ResponseEntity.noContent().build();

    }

    @Operation(
            summary = "Listar todos os usuarios",description = "A listar todos os usuarios cadastrados",
            responses = {
                    @ApiResponse(responseCode = "200",description = "Lista com todos os usuarios ",
                            content = @Content(mediaType ="application/json",
                                    array =@ArraySchema (schema = @Schema(implementation = UsuarioResponseDto.class))))
            }
    )

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        List<Usuario> users = service.buscarTodos();
                return ResponseEntity.ok(UsuarioMapper.toall(users));
    }

}
