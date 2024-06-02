package com.flight_manager.controllers;

import com.flight_manager.controllers.dto.CreatePassengerDto;
import com.flight_manager.entities.Passenger;
import com.flight_manager.services.PassengerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
