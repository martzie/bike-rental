package com.martzie.bikerental.bike.service;

import com.martzie.bikerental.bike.controller.converter.BikeConverter;
import com.martzie.bikerental.bike.controller.dto.BikeRequest;
import com.martzie.bikerental.bike.controller.dto.BikeResponse;
import com.martzie.bikerental.bike.exception.BikeNotFoundException;
import com.martzie.bikerental.bike.exception.SizeNotAvailableException;
import com.martzie.bikerental.bike.model.Bike;
import com.martzie.bikerental.bike.model.Model;
import com.martzie.bikerental.bike.model.Size;
import com.martzie.bikerental.bike.repository.BikeRepository;
import com.martzie.bikerental.bike.repository.ModelRepository;
import com.martzie.bikerental.bike.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository bikeRepository;
    private final ModelRepository modelRepository;
    private final SizeRepository sizeRepository;

    @Transactional
    public BikeResponse addBike(BikeRequest request) {
        Model model = modelRepository.findById(request.modelId()).orElseThrow();
        Size size = sizeRepository.findById(request.sizeId()).orElseThrow();
        List<Size> availableSizes = model.getSizes();
            if (!availableSizes.contains(size)) {
                throw new SizeNotAvailableException();
            }
        Bike bike = new Bike();
        bike.setModel(model);
        bike.setSize(size);
        Bike persistentBike = bikeRepository.save(bike);
        return BikeConverter.mapToBikeResponse(persistentBike);
    }

    public List<BikeResponse> getAllBikes(Long model, Long manufacturer, Long size, Long category) {
        List<Bike> allBikes = bikeRepository.findBikesByOptionalCriteria(model, manufacturer, size, category);
        return BikeConverter.mapToBikeResponses(allBikes);
    }

    public BikeResponse getBikeById(long id) {
        Bike persistentBike = getBike(id);
        return BikeConverter.mapToBikeResponse(persistentBike);
    }

    private Bike getBike(long id) {
        return bikeRepository.findById(id).orElseThrow(() -> new BikeNotFoundException(id));
    }

    public void removeBike(long id) {
        bikeRepository.delete(getBike(id));
    }
}
