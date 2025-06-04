package com.gestion_obras.services.sevicesmanager;

import com.gestion_obras.models.entities.MaterialRequest;
import com.gestion_obras.repositories.MaterialRequestRepository;
import com.gestion_obras.services.GenericServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialRequestServiceManager extends GenericServiceManager<MaterialRequest, MaterialRequestRepository> {

    public List<MaterialRequest> findByUserId(String userId) {
        return this.repository.findByUserId(userId);
    }

}
