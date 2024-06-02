package com.flight_manager.repositories;

import com.flight_manager.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Optional<Passenger> findByEmailOrCpfOrPassportNumber(String email, String cpf, String passportNumber);
}
