package com.martzie.bikerental.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ClientValidationError>> handleValidationError(MethodArgumentNotValidException e) {
        List<ClientValidationError> errors = e.getBindingResult().getFieldErrors()
                .stream()
                .map(ex -> new ClientValidationError(ex.getField(), ex.getRejectedValue(), ex.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
