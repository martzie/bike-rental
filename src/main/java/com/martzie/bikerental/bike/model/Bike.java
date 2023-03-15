package com.martzie.bikerental.bike.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

@Entity
@Getter
@Builder
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String manufacturer;
    private String model;
    private String size;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category bikeCategory;
    private boolean isAvailable;

    @Tolerate
    public Bike(){}
}
