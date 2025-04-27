package com.gestion_obras.models.dtos.workzone;

import com.gestion_obras.models.enums.StatusWorkZone;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class WorkZoneDto {
    private Long projectId;
    private String name;
    private String description;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private StatusWorkZone status;
}