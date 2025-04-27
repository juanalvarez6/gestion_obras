package com.gestion_obras.services.sevicesmanager;

import com.gestion_obras.models.entities.WorkZone;
import com.gestion_obras.repositories.WorkZonesRepository;
import com.gestion_obras.services.GenericServiceManager;
import org.springframework.stereotype.Service;

@Service
public class WorkZoneServiceManager extends GenericServiceManager<WorkZone, WorkZonesRepository> {
}
