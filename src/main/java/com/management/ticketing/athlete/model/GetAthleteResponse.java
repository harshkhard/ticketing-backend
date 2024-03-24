package com.management.ticketing.athlete.model;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class GetAthleteResponse {
    String athleteName;
    String athleteId;
}
