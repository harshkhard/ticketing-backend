package com.management.ticketing.athleteevent.service;

import com.management.ticketing.athlete.entity.Athlete;
import com.management.ticketing.athlete.repo.AthleteRepo;
import com.management.ticketing.athleteevent.entity.AthleteEvent;
import com.management.ticketing.athleteevent.model.AthleteEventResponse;
import com.management.ticketing.athleteevent.model.CreateAthleteEventRequest;
import com.management.ticketing.athleteevent.model.UnRegisterEventRequest;
import com.management.ticketing.athleteevent.repo.AthleteEventRepo;
import com.management.ticketing.event.entity.Event;
import com.management.ticketing.event.repo.EventRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AthleteEventService {

    @Autowired
    private final AthleteEventRepo athleteEventRepo;
    @Autowired
    private final AthleteRepo athleteRepo;
    @Autowired
    private final EventRepo eventRepo;


    public AthleteEventResponse getAllEventsForAthlete(Long athleteId) {
        List<AthleteEvent> athleteEvents = athleteEventRepo.findByAthleteIdAndActive(athleteId, true);
        return AthleteEventResponse.builder()
                .events(athleteEvents.stream().map(it -> it.getEvent())
                        .collect(Collectors.toList())).count(athleteEvents.size()).build();
    }

    public AthleteEventResponse getAllEventsNotRegisteredForUser(Long athleteId) {
        List<Event> events = eventRepo.findUnregisteredEventsOfAthlete(athleteId);
        return AthleteEventResponse.builder().events(events).count(events.size()).build();
    }

    public void createAthleteEvent(CreateAthleteEventRequest athleteEventRequest) {
        Athlete athlete = athleteRepo.findById(athleteEventRequest.getAthleteId()).orElseThrow();
        Event event = eventRepo.findById(athleteEventRequest.getEventId()).orElseThrow();
        AthleteEvent athleteEvent = new AthleteEvent();
        athleteEvent.setAthlete(athlete);
        athleteEvent.setEvent(event);
        athleteEvent.setActive(true);
        athleteEventRepo.save(athleteEvent);
    }

    public void deactivateAthleteEvent(UnRegisterEventRequest unRegisterEventRequest) {
        AthleteEvent athleteEvent = athleteEventRepo
                .findByAthleteIdAndEventIdAndActive(unRegisterEventRequest.getAthleteId(),
                        unRegisterEventRequest.getEventId(), true
        ).orElseThrow();
        athleteEvent.setActive(false);
        athleteEventRepo.save(athleteEvent);
    }
}
