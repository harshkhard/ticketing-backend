package com.management.ticketing.athleteevent.repo;

import com.management.ticketing.athleteevent.entity.AthleteEvent;
import com.management.ticketing.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteEventRepo extends JpaRepository<AthleteEvent, Long> {

    List<AthleteEvent> findByAthleteIdAndActive(Long athleteId, Boolean isActive);

}
