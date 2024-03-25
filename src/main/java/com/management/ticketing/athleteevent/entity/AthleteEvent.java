package com.management.ticketing.athleteevent.entity;

import com.management.ticketing.athlete.entity.Athlete;
import com.management.ticketing.core.entity.Auditable;
import com.management.ticketing.event.entity.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity()
@Table(name = "athlete_event", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"athlete_id", "event_id", "active"})
})
@Getter
@Setter
@ToString
public class AthleteEvent extends Auditable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(nullable = false)
    private Boolean active;
}
