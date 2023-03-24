package com.martzie.bikerental.bike.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManufacturerNotFoundException extends RuntimeException {

    public ManufacturerNotFoundException(long id) {
        super("Manufacturer with id " + id + " does not exist.");
    }
}
