package com.gestion_obras.models.dtos.project;

import com.gestion_obras.models.enums.StatusProject;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class ProjectDto {
    private String name;
    private String description;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDate startDate;
    private LocalDate endDate;
    private StatusProject status;
}