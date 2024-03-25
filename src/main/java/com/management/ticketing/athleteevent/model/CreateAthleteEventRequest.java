package com.management.ticketing.athleteevent.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAthleteEventRequest {

    @NotNull
    Long athleteId;

    @NotNull
    Long eventId;

}
