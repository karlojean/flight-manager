package com.flight_manager.repositories;

import com.flight_manager.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    List<Passenger> findAllByActive(boolean active);

    Optional<Passenger> findByEmailOrCpfOrPassportNumber(String email, String cpf, String passportNumber);
}
