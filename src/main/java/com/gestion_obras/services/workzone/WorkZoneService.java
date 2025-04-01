package com.gestion_obras.services.workzone;

import com.gestion_obras.models.entities.WorkZone;

import java.util.List;
import java.util.Optional;

public interface WorkZoneService {
    List<WorkZone> findAll();

    Optional<WorkZone> findById(Long id);

    WorkZone save(WorkZone workZone);

    boolean delete(Long id);
}
