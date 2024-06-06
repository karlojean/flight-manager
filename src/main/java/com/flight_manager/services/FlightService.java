package com.flight_manager.services;

import com.flight_manager.controllers.dto.CreateFlightDto;
import com.flight_manager.entities.Flight;
import com.flight_manager.exceptions.FlightDateIsIncompatibleException;
import com.flight_manager.repositories.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(CreateFlightDto flight) {

        if(flight.departure().isAfter(flight.arrival())) {
            throw new FlightDateIsIncompatibleException("Departure date is after arrival.");
        }

        var flightCreated = flightRepository.save(flight.toFlight());


        return flightCreated;
    }
}
