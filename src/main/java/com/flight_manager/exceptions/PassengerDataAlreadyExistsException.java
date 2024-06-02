package com.flight_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PassengerDataAlreadyExistsException extends FlightManagerException {


    private String detail;

    public PassengerDataAlreadyExistsException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Passenger data already exists.");
        pb.setDetail(detail);

        return pb;
    }
}
