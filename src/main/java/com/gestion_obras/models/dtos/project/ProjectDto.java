package com.gestion_obras.models.dtos.project;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public ProjectDto(Long id, String name, String description,
                      BigDecimal latitude, BigDecimal longitude,
                      LocalDate startDate, LocalDate endDate,
                      String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public ProjectDto() {
    }

    public enum Status {
        EN_PROGRESO,
        FINALIZADO,
        SUSPENDIDO
    }
}