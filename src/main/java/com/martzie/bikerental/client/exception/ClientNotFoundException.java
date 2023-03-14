package com.martzie.bikerental.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(long id){
        super("Client with id " + id + "does not exist.");
    }
}
