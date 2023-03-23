package com.martzie.bikerental.client.model;

import jakarta.persistence.*;
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
    @Column(updatable = false)
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String emailAddress;
    private String city;
    private String street;
    private String streetNumber;
    private String postcode;
    private String phoneNumber;
    private boolean isActive;

    @Tolerate
    public Client(){}
}
