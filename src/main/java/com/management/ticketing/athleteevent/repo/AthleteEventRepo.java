package com.management.ticketing.athleteevent.repo;

import com.management.ticketing.athlete.entity.Athlete;
import com.management.ticketing.athleteevent.entity.AthleteEvent;
import com.management.ticketing.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AthleteEventRepo extends JpaRepository<AthleteEvent, Long> {

    List<AthleteEvent> findByAthleteIdAndActive(Long athleteId, Boolean isActive);

    Optional<AthleteEvent> findByAthleteIdAndEventIdAndActive(Long athleteId, Long eventId, Boolean isActive);

}
