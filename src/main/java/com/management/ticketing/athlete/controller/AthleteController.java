package com.management.ticketing.athlete.controller;

import com.management.ticketing.athlete.model.CreateUserRequest;
import com.management.ticketing.athlete.model.GetAthleteResponse;
import com.management.ticketing.athlete.model.LoginRequest;
import com.management.ticketing.athlete.service.AthleteService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(value = "/athlete")
public class AthleteController {

    @Autowired
    private final AthleteService athleteService;

    @GetMapping("/")
    List<GetAthleteResponse> getAllUsers() {
        return athleteService.getAllUsers();
    }

    @PostMapping("/")
    GetAthleteResponse createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
         return athleteService.createUser(createUserRequest);
    }

    @PostMapping("/login")
    GetAthleteResponse getAthleteByAthleteId(@Valid @RequestBody LoginRequest loginRequest) {
        return athleteService.getAthleteByAthleteId(loginRequest);
    }

}
