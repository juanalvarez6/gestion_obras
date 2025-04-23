package com.gestion_obras.services.workzone;

import com.gestion_obras.models.entities.WorkZone;
import com.gestion_obras.repositories.WorkZonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkZoneServiceManager implements WorkZoneService {

    @Autowired
    private WorkZonesRepository workZonesRepository;

    @Override
    public List<WorkZone> findAll() {
        List<WorkZone> workZone = new ArrayList<>();
        this.workZonesRepository.findAll().forEach(workZone::add);
        return workZone;
    }

    @Override
    public Optional<WorkZone> findById(Long id) {
        return this.workZonesRepository.findById(id);
    }

    @Override
    public WorkZone save(WorkZone workZone) {
        return this.workZonesRepository.save(workZone);
    }

    @Override
    public boolean delete(Long id) {
        Optional<WorkZone> workZone = workZonesRepository.findById(id);
        if (workZone.isPresent()) {
            workZonesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
