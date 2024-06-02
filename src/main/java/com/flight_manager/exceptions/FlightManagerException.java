package com.flight_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class FlightManagerException extends RuntimeException {

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Flight Manager internal server error.");

        return pb;
    }
}
