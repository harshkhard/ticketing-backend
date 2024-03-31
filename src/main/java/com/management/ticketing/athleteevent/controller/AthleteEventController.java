package com.management.ticketing.athleteevent.controller;

import com.management.ticketing.athleteevent.model.AthleteEventResponse;
import com.management.ticketing.athleteevent.model.CreateAthleteEventRequest;
import com.management.ticketing.athleteevent.model.UnRegisterEventRequest;
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

    @GetMapping("/registered_events")
    AthleteEventResponse getAllEventsForUser(
            @RequestParam(name = "athlete_id") Long athleteId
    ) {
        return athleteEventService.getAllEventsForAthlete(athleteId);
    }

    @GetMapping("/un_registered_events")
    AthleteEventResponse getUnregisteredEventsForUser(
            @RequestParam(name = "athlete_id") Long athleteId
    ) {
        return athleteEventService.getAllEventsNotRegisteredForUser(athleteId);
    }

    @PostMapping("/register_event")
    void addAthleteEvent(@Valid @RequestBody CreateAthleteEventRequest createAthleteEventRequest) {
        athleteEventService.createAthleteEvent(createAthleteEventRequest);
    }

    @PatchMapping("/un_register_event/")
    void deactivateAthleteEvent(@Valid @RequestBody UnRegisterEventRequest unRegisterEventRequest) {
        athleteEventService.deactivateAthleteEvent(unRegisterEventRequest);
    }
}
