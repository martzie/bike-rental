package com.martzie.bikerental.client.controller.dto;

import lombok.Builder;

@Builder
public record ClientResponse(long id, String firstName, String lastName, String emailAddress) {}
