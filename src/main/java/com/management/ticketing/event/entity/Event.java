package com.management.ticketing.event.entity;

import com.management.ticketing.core.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity(name = "event")
@Table(name = "event")
@ToString
@Getter
@Setter

public class Event extends Auditable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String eventCategory;

    @Column(nullable = false)
    String eventName;

    @Column(nullable = false)
    Instant startTime;

    @Column(nullable = false)
    Instant endTime;
}
