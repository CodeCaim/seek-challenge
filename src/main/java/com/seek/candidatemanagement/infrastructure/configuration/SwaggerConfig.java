package com.seek.candidatemanagement.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        .info(new Info().title("SEEK Challenge (Carlos Alberto Infantas Mota)").version("1.0.0").description("API for managing candidates and their recruitment status"))				
        .addSecurityItem(new SecurityRequirement().addList("SeekSecurityScheme"))
        .components(new Components().addSecuritySchemes("SeekSecurityScheme", new SecurityScheme()
        .name("SeekSecurityScheme").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
