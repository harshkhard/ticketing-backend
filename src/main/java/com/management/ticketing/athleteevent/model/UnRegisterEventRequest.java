package com.management.ticketing.athleteevent.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class UnRegisterEventRequest {

    @NotNull
    Long eventId;

    @NotNull
    Long athleteId;
}
