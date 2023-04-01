package com.martzie.bikerental.bike.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SizeNotAvailableException extends RuntimeException {

    public SizeNotAvailableException() {
        super("Requested size is not available for requested model");
    }
}
