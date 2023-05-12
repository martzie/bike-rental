package com.martzie.bikerental.client.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientRequest {

    @Email(message = "{email.format}")
    @NotBlank(message = "{email.notempty}")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "user@domain.com")
    private String emailAddress;

    @NotBlank(message = "{name.notempty}")
    @NotNull(message = "{name.notnull}")
    @Size(min = 3, max = 30, message = "{name.size}")
    @Schema(example = "John")
    private String firstName;

    @NotBlank(message = "{lastname.notempty}")
    @NotNull(message = "{lastname.notnull}")
    @Size(min = 3, max = 30, message = "{lastname.size}")
    @Schema(example = "Smith")
    private String lastName;

    @Size(min = 3, max = 30, message = "{city.name.size}")
    private String city;

    @Size(min = 3, max = 50, message = "{street.name.size}")
    private String street;

    @NotBlank(message = "{street.number.notempty}")
    private String streetNumber;

    @Pattern(regexp = "^\\d{2}[- ]?\\d{3}$", message = "{postcode.format}")
    private String postcode;

    @NotNull(message = "{phonenumber.notnull}")
    @NotBlank(message = "{phonenumber.notempty}")
    @Pattern(regexp = "^\\d{8,10}$", message = "{phonenumber.format}")
    private String phoneNumber;

}
