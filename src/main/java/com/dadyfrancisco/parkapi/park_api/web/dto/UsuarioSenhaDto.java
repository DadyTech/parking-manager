package com.dadyfrancisco.parkapi.park_api.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter @NoArgsConstructor
@ToString @AllArgsConstructor
public class UsuarioSenhaDto {
    @NotBlank
    @Size(min = 6,max = 6 )
    private String SenhaAtual;
    @NotBlank
    @Size(min = 6,max = 6 )
    private String NovaSenha;
    @NotBlank
    @Size(min = 6,max = 6 )
    private String confiramarSenha;
}
