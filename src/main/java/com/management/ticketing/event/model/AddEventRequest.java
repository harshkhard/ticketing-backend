package com.management.ticketing.event.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class AddEventRequest {
    @NotEmpty
    String eventName;
    @NotEmpty
    String eventCategory;
    @NotNull
    Instant startTime;
    @NotNull
    Instant endTime;
}
