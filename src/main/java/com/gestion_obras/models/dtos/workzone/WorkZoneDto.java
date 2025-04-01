package com.gestion_obras.models.dtos.workzone;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class WorkZoneDto {
    private Integer id;
    private Integer projectId;
    private String projectName;
    private String name;
    private String description;
    private BigDecimal latitude;
    private BigDecimal longitude;
}