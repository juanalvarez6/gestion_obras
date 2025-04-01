package com.gestion_obras.services.project;

import com.gestion_obras.models.dtos.project.ProjectDto;
import com.gestion_obras.models.entities.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> findAll();

    Optional<Project> findById(Long id);

    Project save(Project project);

    boolean delete(Long id);
}
