package com.martzie.bikerental.client.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientRequest {

    @Email(message = "Invalid email: Email must be in user@domain.com format")
    @NotBlank(message = "Invalid email: Email cannot be empty")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "user@domain.com")
    private String emailAddress;

    @NotBlank(message = "Invalid Name: cannot be empty")
    @NotNull(message = "Invalid Name: cannot be null")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    @Schema(example = "John")
    private String firstName;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "Smith", minLength = 3, maxLength = 20)
    private String lastName;

    @Size(min = 3, max = 30, message = "Invalid city name: Must be of 3 - 30 characters")
    private String city;

    @Size(min = 3, max = 50, message = "Invalid street name: Must be of 3 - 50 characters")
    private String street;

    @NotBlank(message = "Invalid street number: cannot be blank")
    private String streetNumber;

    @Pattern(regexp = "^\\d{2}[- ]?\\d{3}$", message = "Postcode must be in 5 digit format ex. 00-000 or 00000")
    private String postcode;

    @NotNull(message = "Invalid phone number: cannot be null")
    @NotBlank(message = "Invalid phone number: cannot be empty")
    @Pattern(regexp = "^\\d{8,10}$", message = "Phone number must contain 8-10 digits")
    private String phoneNumber;

}
