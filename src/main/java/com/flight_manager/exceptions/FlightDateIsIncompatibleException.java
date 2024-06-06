package com.flight_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class FlightDateIsIncompatibleException extends FlightManagerException {

    private String detail;


    public FlightDateIsIncompatibleException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Flight date is incompatible.");
        pb.setDetail(detail);

        return pb;
    }
}
