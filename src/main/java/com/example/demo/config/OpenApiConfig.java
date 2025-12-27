package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // API Info
                .info(new Info()
                        .title("Leave Overlap & Team Capacity Analyzer API")
                        .description("REST API for managing employee leave requests and analyzing team capacity")
                        .version("1.0"))

                // Server configuration
                .servers(List.of(
                        new Server().url("https://9098.408procr.amypo.ai/")
                ))

                // Security requirement
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))

                // Security scheme
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
