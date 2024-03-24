package com.management.ticketing.athlete.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class CreateUserRequest {
    @NotEmpty
    String athleteName;
    @NotEmpty
    String athleteId;
}
