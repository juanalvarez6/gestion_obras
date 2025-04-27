package com.gestion_obras.models.dtos.attendance;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AttendanceDto {
    private String userId;
    private Long zoneId;
}