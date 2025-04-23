package com.gestion_obras.repositories;

import com.gestion_obras.models.entities.WorkZone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkZonesRepository extends JpaRepository<WorkZone, Long> {
}
