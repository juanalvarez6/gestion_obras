package com.gestion_obras.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "zone_id", nullable = false)
    private WorkZone zone;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @JoinColumn(name = "assigned_to", nullable = false)
    private Integer assignedTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "ENUM('PENDIENTE', 'EN_PROGRESO', 'COMPLETADA', 'CANCELADA')")
    private Status status;

    @Column(name = "evidence", columnDefinition = "TEXT")
    private String evidence;

    public enum Status {
        PENDIENTE,
        EN_PROGRESO,
        COMPLETADA,
        CANCELADA
    }
}