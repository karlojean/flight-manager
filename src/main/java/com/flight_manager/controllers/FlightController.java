package com.flight_manager.controllers;

import com.flight_manager.controllers.dto.CreateFlightDto;
import com.flight_manager.entities.Flight;
import com.flight_manager.repositories.FlightRepository;
import com.flight_manager.services.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Flight>> getAll() {
        return ResponseEntity.ok().body(flightService.getAll());
    }


    @PostMapping("{flightId}/add/{passengerId}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable Long flightId, @PathVariable Long passengerId) {
        Flight updatedFlight = flightService.addPassengerToFlight(flightId, passengerId);

        return ResponseEntity.ok().body(updatedFlight);
    }

    @PostMapping("{flightId}/remove/{passengerId}")
    public ResponseEntity<Flight> removePassengerToFlight(@PathVariable Long flightId, @PathVariable Long passengerId) {
        Flight updatedFlight = flightService.removePassengerToFlight(flightId, passengerId);

        return ResponseEntity.ok().body(updatedFlight);
    }
}
