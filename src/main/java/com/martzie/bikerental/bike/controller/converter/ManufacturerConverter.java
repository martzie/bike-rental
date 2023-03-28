package com.martzie.bikerental.bike.controller.converter;

import com.martzie.bikerental.bike.controller.dto.ManufacturerRequest;
import com.martzie.bikerental.bike.controller.dto.ManufacturerResponse;
import com.martzie.bikerental.bike.model.Manufacturer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ManufacturerConverter {

    public static Manufacturer mapToManufacturerEntity(ManufacturerRequest request){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturer(request.manufacturer());
        return manufacturer;
    }

    public static List<ManufacturerResponse> mapToManufacturerResponses(List<Manufacturer> allManufacturers) {
        return allManufacturers.stream()
                .map(ManufacturerConverter::mapToManufacturerResponse)
                .collect(Collectors.toList());
    }

    public static ManufacturerResponse mapToManufacturerResponse(Manufacturer persistentManufacturer) {
        ManufacturerResponse manufacturerResponse =
                new ManufacturerResponse(persistentManufacturer.getId(), persistentManufacturer.getManufacturer());
        return manufacturerResponse;
    }
}
