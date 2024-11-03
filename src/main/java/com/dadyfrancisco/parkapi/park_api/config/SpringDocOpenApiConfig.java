package com.dadyfrancisco.parkapi.park_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openApi(){
       return new OpenAPI()
               .info(
                       new Info()
                               .title("REST API - Spring park")
                               .description("Esta API permite realizar operações CRUD para gerenciar estacionamento, " +
                                       "como cadastrar veículos, controlar vagas, e monitorar entradas e saídas de veículos")
                               .version("v1")
                               .license(new License().name("Apache 2.0").url(
                                       "https://www.apache.org/licenses/LICENSE-2.0.html"))
                               .contact(new Contact().name("Dady francisco").email("dev_dady.outlook.com"))
               );
    }


}
