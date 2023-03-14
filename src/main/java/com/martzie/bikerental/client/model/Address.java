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
public class Address {

    @Id
    @GeneratedValue
    private long id;
    private String city;
    private String street;
    private String streetNumber;
    private String postcode;

    @Tolerate
    public Address(){}
}
