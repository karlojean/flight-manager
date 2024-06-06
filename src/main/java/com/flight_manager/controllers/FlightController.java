package com.flight_manager.controllers;

import com.flight_manager.controllers.dto.CreateFlightDto;
import com.flight_manager.entities.Flight;
import com.flight_manager.repositories.FlightRepository;
import com.flight_manager.services.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody @Valid CreateFlightDto flight) {
        var flightCreated = flightService.createFlight(flight);

        return ResponseEntity.ok().body(flightCreated);
    }


}
