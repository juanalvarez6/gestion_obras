package com.gestion_obras.models.dtos.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private Integer zoneId;
    private String zoneName;
    private String name;
    private String description;
    private String assignedTo;
    private String assignedUserName;
    private String status;
    private String evidence;

    public TaskDto() {
    }

    public TaskDto(Long id, Integer zoneId, String name, String description,
                   String assignedTo, String status, String evidence) {
        this.id = id;
        this.zoneId = zoneId;
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = status;
        this.evidence = evidence;
    }

    public enum Status {
        PENDIENTE,
        EN_PROGRESO,
        COMPLETADA,
        CANCELADA
    }
}