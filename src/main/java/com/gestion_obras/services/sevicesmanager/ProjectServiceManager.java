package com.gestion_obras.services.sevicesmanager;

import com.gestion_obras.models.entities.Project;
import com.gestion_obras.repositories.ProjectRepository;
import com.gestion_obras.services.GenericServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceManager extends GenericServiceManager<Project, ProjectRepository> {
}