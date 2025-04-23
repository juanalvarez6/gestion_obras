package com.gestion_obras.repositories;

import com.gestion_obras.models.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
