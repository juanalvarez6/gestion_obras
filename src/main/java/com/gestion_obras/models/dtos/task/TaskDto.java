package com.gestion_obras.models.dtos.task;

import com.gestion_obras.models.enums.PriorityTask;
import com.gestion_obras.models.enums.StatusTask;
import lombok.Getter;

@Getter
public class TaskDto {
    private Long zoneId;
    private String name;
    private String description;
    private String UserId;
    private PriorityTask priorityTask;
    private String evidence;
}