package com.management.ticketing.event.service;

import com.management.ticketing.event.entity.Event;
import com.management.ticketing.event.model.AddEventRequest;
import com.management.ticketing.event.model.GetEventResponse;
import com.management.ticketing.event.repo.EventRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {
    @Autowired
    private final EventRepo eventRepo;

    public List<GetEventResponse> getAllEvents() {
        return eventRepo.findAll()
                .stream()
                .map(it -> GetEventResponse.builder()
                        .id(it.getId())
                        .eventName(it.getEventName())
                        .eventCategory(it.getEventCategory())
                        .startTime(it.getStartTime())
                        .endTime(it.getEndTime())
                        .build())
                .collect(Collectors.toList());
    }

    public void addEvent(AddEventRequest addEventRequest) {
        Event event = new Event();
        event.setEventName(addEventRequest.getEventName());
        event.setEventCategory(addEventRequest.getEventCategory());
        event.setStartTime(addEventRequest.getStartTime());
        event.setEndTime(addEventRequest.getEndTime());
        eventRepo.save(event);
    }
}
