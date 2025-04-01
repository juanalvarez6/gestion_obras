package com.gestion_obras.services.task;

import com.gestion_obras.models.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task);

    boolean delete(Long id);

}
