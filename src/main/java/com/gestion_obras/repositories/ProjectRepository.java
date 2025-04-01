package com.gestion_obras.repositories;

import com.gestion_obras.models.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}