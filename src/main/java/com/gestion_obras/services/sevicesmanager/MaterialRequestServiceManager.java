package com.gestion_obras.services.sevicesmanager;

import com.gestion_obras.models.entities.MaterialRequest;
import com.gestion_obras.repositories.MaterialRequestRepository;
import com.gestion_obras.services.GenericServiceManager;
import org.springframework.stereotype.Service;

@Service
public class MaterialRequestServiceManager extends GenericServiceManager<MaterialRequest, MaterialRequestRepository> {
}
