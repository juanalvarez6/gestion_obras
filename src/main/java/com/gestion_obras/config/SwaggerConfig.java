package com.gestion_obras.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Construction Management API REST",
                version = "1.0",
                description = "Documentation for API REST for Construction Management"
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "Local server"
        )
    )
public class SwaggerConfig { }
