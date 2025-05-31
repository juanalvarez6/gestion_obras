package com.gestion_obras.services.sevicesmanager;

import com.gestion_obras.models.entities.AssignUserZone;
import com.gestion_obras.models.entities.WorkZone;
import com.gestion_obras.repositories.AssignUserZoneRepository;
import com.gestion_obras.services.GenericServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignUserZoneServiceManager extends GenericServiceManager<AssignUserZone, AssignUserZoneRepository> {

    public Optional<WorkZone> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

}