package com.management.ticketing.athlete.service;

import com.management.ticketing.athlete.entity.Athlete;
import com.management.ticketing.athlete.model.CreateUserRequest;
import com.management.ticketing.athlete.model.GetAthleteResponse;
import com.management.ticketing.athlete.repo.AthleteRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AthleteService {
    @Autowired
    private final AthleteRepo athleteRepo;

    public List<GetAthleteResponse> getAllUsers() {
        return athleteRepo.findAll().stream().map(
                        it -> GetAthleteResponse.builder().athleteId(
                                it.getAthleteId()).athleteName(it.getAthleteName()).build())
                .collect(Collectors.toList());
    }

    public void createUser(CreateUserRequest createUserRequest) {
        Athlete athlete = new Athlete();
        athlete.setAthleteName(createUserRequest.getAthleteName());
        athlete.setAthleteId(createUserRequest.getAthleteId());
        athleteRepo.save(athlete);
        log.info("created user " + athlete.toString());
    }

    public GetAthleteResponse getAthleteByAthleteId(String athleteId) {
        Athlete athlete = athleteRepo.findByAthleteId(athleteId).orElse(null);
        if (Objects.isNull(athlete)) {
            throw new RuntimeException("No user found with given athlete id " + athleteId);
        } else {
            return GetAthleteResponse.builder()
                    .athleteName(athlete.getAthleteName()).athleteId(athlete.getAthleteId()).build();
        }
    }
}
