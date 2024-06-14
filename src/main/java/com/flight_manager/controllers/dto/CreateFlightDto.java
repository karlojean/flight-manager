package com.flight_manager.controllers.dto;

import com.flight_manager.entities.Flight;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateFlightDto (
        @NotBlank
        String origin,

        @NotBlank
        String destination,

        @NotNull
        @Future(message = "Departure must be a future data")
        LocalDate departure,

        @NotNull
        @Future(message = "Arrival must be a future data")
        LocalDate arrival,

        @NotNull
        Integer numberOfPassengers
) {
        public Flight toFlight() {
                return new Flight(origin, destination, departure, arrival, numberOfPassengers);
        }
}
