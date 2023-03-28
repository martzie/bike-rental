package com.martzie.bikerental.bike.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SizeAlreadyExistsException extends RuntimeException {

    public SizeAlreadyExistsException() {
        super("Size is already registered");
    }
}
