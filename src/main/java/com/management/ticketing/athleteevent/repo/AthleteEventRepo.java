package com.management.ticketing.athleteevent.repo;

import com.management.ticketing.athleteevent.entity.AthleteEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AthleteEventRepo extends JpaRepository<AthleteEvent, Long> {

    List<AthleteEvent> findByAthleteIdAndActive(Long athleteId, Boolean isActive);
}
