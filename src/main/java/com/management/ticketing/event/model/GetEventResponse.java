package com.management.ticketing.event.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

public class GetEventResponse {
    Long id;
    String eventName;
    String eventCategory;
    Instant startTime;
    Instant endTime;
}
