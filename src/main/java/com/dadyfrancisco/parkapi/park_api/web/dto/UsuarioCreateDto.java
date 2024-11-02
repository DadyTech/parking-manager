package com.dadyfrancisco.parkapi.park_api.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioCreateDto {
    @Email(regexp ="Formato do e-mail esta invalido" )
    @NotBlank
    private  String username;
    @NotBlank
    @Size(min = 6,max = 6 )
    private  String password;
}
