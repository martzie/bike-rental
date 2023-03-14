package com.martzie.bikerental.client.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientDTO {

    private long id;
    private String login;
    private String firstName;
    private String lastName;
    private String emailAddress;
}
