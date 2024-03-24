package com.management.ticketing.athlete.entity;

import com.management.ticketing.core.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "athlete")
@ToString
@Getter
@Setter
public class Athlete extends Auditable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(nullable = false)
    String athleteName;

    @Column(nullable = false, unique = true)
    String athleteId;
}
