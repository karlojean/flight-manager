package com.flight_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.flight_manager.exceptions.FlightCapacityExceededException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="tb_flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String origin;

    private String destination;

    private LocalDate departure;

    private LocalDate arrival;

    @ManyToMany(mappedBy = "flights")
    @JsonIgnoreProperties("flights")
    private Set<Passenger> passengers;

    private Integer numberOfPassengers;

    public Flight() {
    }

    public Flight(String origin, String destination, LocalDate departure, LocalDate arrival, Integer numberOfPassengers) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Long getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassenger) {
        this.numberOfPassengers = numberOfPassenger;
    }

    public void addPassenger(Passenger passenger) {
        if(this.passengers.size() >= this.numberOfPassengers) {
            throw new FlightCapacityExceededException();
        }
        this.passengers.add(passenger);
        passenger.getFlights().add(this);
    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
        passenger.getFlights().remove(this);
    }
}
