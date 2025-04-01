package com.gestion_obras.models.dtos.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String rol;
    private LocalDateTime createdAt;

    private String password;

    public UserDto() {
    }

    public UserDto(String id, String name, String email, String rol, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rol = rol;
        this.createdAt = createdAt;
    }

    // Enumeración para roles (opcional)
    public enum Rol {
        ADMIN,
        SUPERVISOR,
        TRABAJADOR
    }

    public static UserDto forCreation(String name, String email, String password, String rol) {
        UserDto dto = new UserDto();
        dto.setName(name);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setRol(rol);
        return dto;
    }
}