package com.martzie.bikerental.bike.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SizeNotFoundException extends RuntimeException {

    public SizeNotFoundException(long id) {
        super("Size with id " + id + "does not exist.");
    }
}
