package com.dadyfrancisco.parkapi.park_api.web.dto;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class UsuarioResponseDto {

    private Long id;

    private  String username;

    private  String role;
}
