package com.martzie.bikerental.bike.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ManufacturerAlreadyExistsException extends RuntimeException {

    public ManufacturerAlreadyExistsException(){
        super("Manufacturer is already registered.");
    }
}
