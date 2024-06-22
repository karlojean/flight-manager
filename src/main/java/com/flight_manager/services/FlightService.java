package com.flight_manager.services;

import com.flight_manager.controllers.dto.CreateFlightDto;
import com.flight_manager.entities.Flight;
import com.flight_manager.entities.Passenger;
import com.flight_manager.exceptions.*;
import com.flight_manager.repositories.FlightRepository;
import com.flight_manager.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;

    public FlightService(FlightRepository flightRepository, PassengerRepository passengerRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
    }

    public Flight createFlight(CreateFlightDto flight) {

        if(flight.departure().isAfter(flight.arrival())) {
            throw new FlightDateIsIncompatibleException("Departure date is after arrival.");
        }

        var flightCreated = flightRepository.save(flight.toFlight());


        return flightCreated;
    }

    public List<Flight> getAll() {
        var flights = flightRepository.findAll();

        return flights;
    }

    public Flight addPassengerToFlight(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(FlightNotFound::new);

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(PassengerNotFound::new);

        if(!passenger.isActive()) {
            throw new PassengerIsDisabledException();
        }

        flight.getPassengers().forEach(p -> {
            if (Objects.equals(p.getId(), passenger.getId())) {
                throw new PassengerIsAlreadyOnTheFlightException();
            }
        });

        flight.addPassenger(passenger);

        return flightRepository.save(flight);
    }

    public Flight removePassengerToFlight(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(FlightNotFound::new);

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(PassengerNotFound::new);

        if (!flight.getPassengers().contains(passenger)) {
            throw new PassengerNotOnFlightException();
        }

        flight.removePassenger(passenger);
        return flightRepository.save(flight);
    }

}
