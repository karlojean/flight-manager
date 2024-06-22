package com.flight_manager.controllers;

import com.flight_manager.controllers.dto.CreatePassengerDto;
import com.flight_manager.entities.Passenger;
import com.flight_manager.services.PassengerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody @Valid CreatePassengerDto passenger) {

        var passengerCreated = passengerService.createPassenger(passenger);

        return ResponseEntity.ok(passengerCreated);
    }

    @GetMapping
    public ResponseEntity<List<Passenger>> getPassengers(@RequestParam(defaultValue = "false") boolean includeInactive) {
        List<Passenger> passengers = passengerService.getPassengers(includeInactive);

        return ResponseEntity.ok().body(passengers);
    }

    @PostMapping("{id}/deactivate")
    public ResponseEntity<Passenger> disablePassenger(@PathVariable Long id) {
        var passenger = passengerService.disablePassenger(id);
        return ResponseEntity.ok().body(passenger);
    }

    @PostMapping("{id}/active")
    public ResponseEntity<Passenger> activePassenger(@PathVariable Long id) {
        var passenger = passengerService.activePassenger(id);
        return ResponseEntity.ok().body(passenger);
    }
}
