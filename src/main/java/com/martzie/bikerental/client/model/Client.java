package com.martzie.bikerental.client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity
@Getter
@Setter
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(max=30)
    @Column(unique = true)
    private String login;
    private String firstName;
    private String lastName;

    @Email
    @NotNull
    @Column(unique = true)
    private String emailAddress;
    private String city;
    private String street;
    private String streetNumber;
    private String postcode;

    @Tolerate
    public Client(){}
}
