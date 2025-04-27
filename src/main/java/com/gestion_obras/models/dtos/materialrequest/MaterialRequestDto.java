package com.gestion_obras.models.dtos.materialrequest;

import com.gestion_obras.models.enums.StatusMaterialRequest;
import lombok.Getter;

@Getter
public class MaterialRequestDto {
    private Long materialId;
    private Long projectId;
    private String userId;
    private int requestedQuantity;
    private String comments;
    private StatusMaterialRequest status;
}
