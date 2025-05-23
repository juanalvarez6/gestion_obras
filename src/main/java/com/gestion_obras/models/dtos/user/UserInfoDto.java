package com.gestion_obras.models.dtos.user;

import com.gestion_obras.models.enums.RoleType;
import lombok.Getter;

@Getter
public class UserInfoDto {
    private String id;
    private String name;
    private String email;
    private RoleType role;
}