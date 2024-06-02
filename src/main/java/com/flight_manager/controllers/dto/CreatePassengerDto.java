package com.flight_manager.controllers.dto;

import com.flight_manager.entities.Passenger;
import com.flight_manager.validations.CPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreatePassengerDto(
  @NotBlank(message = "must not be blank")
  String name,

  @NotBlank(message = "must not be blank")
  @Pattern(regexp = "\\d{11}", message = "CPF must contain only 11 digits")
  @CPF
  String cpf,

  @NotBlank(message = "must not be blank")
  String passportNumber,

  @NotBlank(message = "must not be blank")
  @Email(message = "must be a valid email address")
  String email

){
    public Passenger toPassenger(){
        return new Passenger(name, cpf, passportNumber, email);
    }
}
