package com.management.ticketing.athleteevent.model;

import com.management.ticketing.athlete.entity.Athlete;
import com.management.ticketing.event.entity.Event;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class AthleteEventResponse {
    int count;
    List<Event> events;

}
