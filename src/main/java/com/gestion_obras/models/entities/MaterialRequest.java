package com.gestion_obras.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "material_requests")
public class MaterialRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Project proyecto;

    @JoinColumn(name = "requested_by", nullable = false)
    private Integer requestedBy;

    @Column(name = "cantidad_solicitada", nullable = false)
    private int cantidadSolicitada;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, columnDefinition = "ENUM('PENDIENTE', 'APROBADA', 'RECHAZADA')")
    private Estado estado;

    @PrePersist
    protected void onCreate() {
        this.fechaSolicitud = LocalDateTime.now();
    }

    public enum Estado {
        PENDIENTE,
        APROBADA,
        RECHAZADA
    }
}