package com.martzie.bikerental.client.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientResponse {

    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private boolean isActive;
}
