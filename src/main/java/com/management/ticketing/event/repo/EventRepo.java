package com.management.ticketing.event.repo;

import com.management.ticketing.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

    @Query(nativeQuery = true,
            value = "select * from event " +
                    "where id not in " +
                    "(select event_id from athlete_event " +
                    "where active = true and athlete_id = :athleteId)")
    List<Event> findUnregisteredEventsOfAthlete(@Param("athleteId") Long athleteId);
}
