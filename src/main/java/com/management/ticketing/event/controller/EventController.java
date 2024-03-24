package com.management.ticketing.event.controller;

import com.management.ticketing.event.model.AddEventRequest;
import com.management.ticketing.event.model.GetEventResponse;
import com.management.ticketing.event.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/event")
public class EventController {
    @Autowired
    private final EventService eventService;

    @GetMapping("/")
    private List<GetEventResponse> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/")
    void addEvent(@Valid @RequestBody AddEventRequest addEventRequest) {
        eventService.addEvent(addEventRequest);
    }

}
