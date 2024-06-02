package com.flight_manager.controllers;

import com.flight_manager.exceptions.FlightManagerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandle {

    @ExceptionHandler(value = FlightManagerException.class)
    public ProblemDetail handleFlightManagerException(FlightManagerException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var fieldErrors = e.getFieldErrors().stream().map(f -> new InvalidParam(f.getField(), f.getDefaultMessage())).toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Your request parameters didn't validate");
        pb.setProperty("invalid-param", fieldErrors);

        return pb;
    }

    private record InvalidParam(String name, String reason){};
}
