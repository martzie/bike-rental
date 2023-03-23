package com.martzie.bikerental.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientValidationError {

    private String field;
    private Object rejectedValue;
    private String defaultMessage;

}
