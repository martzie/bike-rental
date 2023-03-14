package com.martzie.bikerental.bike.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Bike {

    @Id
    @GeneratedValue
    private long id;

    private String manufacturer;
    private String model;
    private String size;
    private String bikeType;

}
