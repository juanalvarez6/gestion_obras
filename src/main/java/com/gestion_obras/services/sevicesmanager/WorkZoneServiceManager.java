package com.gestion_obras.services.sevicesmanager;

import com.gestion_obras.models.entities.WorkZone;
import com.gestion_obras.models.enums.StatusWorkZone;
import com.gestion_obras.repositories.WorkZonesRepository;
import com.gestion_obras.services.GenericServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkZoneServiceManager extends GenericServiceManager<WorkZone, WorkZonesRepository> {

    @Transactional
    public int updateWorkZoneStatus(Long id, StatusWorkZone status) {
        return repository.updateStatusById(id, status);
    }

    @Transactional(readOnly = true)
    public List<WorkZone> findZoneByUserId(String userId){
        return repository.findZoneByUserId(userId);
    }

}
