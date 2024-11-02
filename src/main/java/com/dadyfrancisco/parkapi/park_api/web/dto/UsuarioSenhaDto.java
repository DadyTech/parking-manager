package com.dadyfrancisco.parkapi.park_api.web.dto;

import lombok.*;

@Setter
@Getter @NoArgsConstructor
@ToString @AllArgsConstructor
public class UsuarioSenhaDto {

    private String SenhaAtual;
    private String NovaSenha;
    private String confiramarSenha;
}
