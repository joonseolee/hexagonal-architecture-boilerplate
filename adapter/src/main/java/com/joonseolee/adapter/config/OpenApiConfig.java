package com.joonseolee.adapter.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("hexagonal-architecture-boilerplate")
                .version("0.1")
                .description("boilerplate")
        ).components(new Components()
                .addSecuritySchemes("bearerAuth", securityScheme()));
    }

    private SecurityScheme securityScheme() {
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.type(SecurityScheme.Type.HTTP);
        securityScheme.scheme("bearer");
        securityScheme.bearerFormat("JWT");
        securityScheme.name("Authentication");
        securityScheme.in(SecurityScheme.In.HEADER);

        return securityScheme;
    }
}
