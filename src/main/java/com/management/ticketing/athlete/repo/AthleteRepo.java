package com.management.ticketing.athlete.repo;

import com.management.ticketing.athlete.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AthleteRepo extends JpaRepository<Athlete, Long> {
    Optional<Athlete> findByAthleteId(String athleteId);
}
