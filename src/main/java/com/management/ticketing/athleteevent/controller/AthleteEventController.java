package com.management.ticketing.athleteevent.controller;

import com.management.ticketing.athleteevent.model.AthleteEventResponse;
import com.management.ticketing.athleteevent.model.CreateAthleteEventRequest;
import com.management.ticketing.athleteevent.service.AthleteEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/athlete_event")
public class AthleteEventController {

    @Autowired
    private final AthleteEventService athleteEventService;

    @GetMapping("/")
    AthleteEventResponse getAllEventsForUser(@RequestParam(name = "athlete_id") Long athleteId) {
        return athleteEventService.getAllEventsForAthlete(athleteId);
    }

    @PostMapping("/")
    void addAthleteEvent(@Valid @RequestBody CreateAthleteEventRequest createAthleteEventRequest) {
        athleteEventService.createAthleteEvent(createAthleteEventRequest);
    }

    @PatchMapping("/deactivate/")
    void deactivateAthleteEvent(@RequestParam("id") Long id) {
        athleteEventService.deactivateAthleteEvent(id);
    }
}
