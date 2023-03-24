package com.martzie.bikerental.bike.service;

import com.martzie.bikerental.bike.controller.converter.ManufacturerConverter;
import com.martzie.bikerental.bike.controller.dto.ManufacturerRequest;
import com.martzie.bikerental.bike.controller.dto.ManufacturerResponse;
import com.martzie.bikerental.bike.exception.ManufacturerAlreadyExistsException;
import com.martzie.bikerental.bike.exception.ManufacturerNotFoundException;
import com.martzie.bikerental.bike.model.Manufacturer;
import com.martzie.bikerental.bike.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Transactional
    public ManufacturerResponse addManufacturer(ManufacturerRequest request) {
        checkManufacturer(request.manufacturer());
        Manufacturer persistentManufacturer =
                manufacturerRepository.save(ManufacturerConverter.mapToManufacturerEntity(request));
        return ManufacturerConverter.mapToManufacturerResponse(persistentManufacturer);
    }

    private void checkManufacturer(String manufacturer) {
        if (manufacturerRepository.existsByManufacturerIgnoreCase(manufacturer)) {
            throw new ManufacturerAlreadyExistsException();
        }
    }

    public ManufacturerResponse getManufacturerById(long id) {
        Manufacturer persistentManufacturer = findById(id);
        return ManufacturerConverter.mapToManufacturerResponse(persistentManufacturer);
    }

    public List<ManufacturerResponse> getAllManufacturers() {
        List<Manufacturer> allManufacturers = manufacturerRepository.findAll();
        return ManufacturerConverter.mapToManufacturerResponses(allManufacturers);
    }

    @Transactional
    public void removeManufacturer(long id) {
        Manufacturer manufacturerToDelete = findById(id);
        manufacturerRepository.delete(manufacturerToDelete);
    }

    private Manufacturer findById(long id){
        return manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
    }
}
