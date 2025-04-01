package com.gestion_obras.repositories;

import com.gestion_obras.models.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
