package com.martzie.bikerental.bike.controller.converter;

import com.martzie.bikerental.bike.controller.dto.BikeResponse;
import com.martzie.bikerental.bike.model.Bike;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BikeConverter {

    public static BikeResponse mapToBikeResponse(Bike bike){
        return BikeResponse.builder()
                .id(bike.getId())
                .model(bike.getModel().getModel())
                .manufacturer(bike.getModel().getManufacturer().getManufacturer())
                .category(bike.getModel().getCategory().getCategory())
                .size(bike.getSize().getSize())
                .build();
    }

    public static List<BikeResponse> mapToBikeResponses(List<Bike> bikes){
        return bikes.stream()
                .map(BikeConverter::mapToBikeResponse)
                .collect(Collectors.toList());
    }
}
