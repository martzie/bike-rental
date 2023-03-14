package com.martzie.bikerental.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class IncorrectEmailException extends RuntimeException {
    public IncorrectEmailException(String emailAddress) {
        super(emailAddress + " is an incorrect email format.");
    }
}
