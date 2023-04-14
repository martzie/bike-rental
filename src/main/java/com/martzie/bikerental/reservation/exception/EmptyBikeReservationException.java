package com.martzie.bikerental.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyBikeReservationException extends RuntimeException{

    public EmptyBikeReservationException() {
        super("Reservation has to contain at least one bike");
    }
}
