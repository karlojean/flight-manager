package com.flight_manager.services;

import com.flight_manager.controllers.PassengerController;
import com.flight_manager.controllers.dto.CreatePassengerDto;
import com.flight_manager.entities.Passenger;
import com.flight_manager.exceptions.PassengerAlreadyDeactivatedException;
import com.flight_manager.exceptions.PassengerDataAlreadyExistsException;
import com.flight_manager.exceptions.PassengerHasAssociatedFlightsException;
import com.flight_manager.exceptions.PassengerNotFound;
import com.flight_manager.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger createPassenger(CreatePassengerDto passenger) {
        var passengerDb = passengerRepository.findByEmailOrCpfOrPassportNumber(passenger.email(), passenger.cpf(), passenger.passportNumber());

        if (passengerDb.isPresent()) {
            throw new PassengerDataAlreadyExistsException("Email, cpf or PassportNumber already exists");
        }

        var passengerCreated = passengerRepository.save(passenger.toPassenger());

        return passengerCreated;
    }

    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }

    public Passenger disablePassenger(Long id) {
        var passenger = passengerRepository.findById(id).orElseThrow(PassengerNotFound::new);

        if(!passenger.getFlights().isEmpty()) {
            throw new PassengerHasAssociatedFlightsException();
        }

        if(!passenger.isActive()) {
            throw new PassengerAlreadyDeactivatedException();
        }

        passenger.setActive(false);
        passengerRepository.save(passenger);

        return passenger;
    }
}
