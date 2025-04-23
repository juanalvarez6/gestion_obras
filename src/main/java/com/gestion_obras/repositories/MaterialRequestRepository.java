package com.gestion_obras.repositories;

import com.gestion_obras.models.entities.MaterialRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRequestRepository extends JpaRepository<MaterialRequest, Long> {
}
