package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.controller.dto.BikeRequest;
import com.martzie.bikerental.bike.controller.dto.BikeResponse;
import com.martzie.bikerental.bike.model.Bike;
import com.martzie.bikerental.bike.service.BikeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Bikes")
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @GetMapping()
    public List<BikeResponse> getBikes(@RequestParam(required = false) Long model,
                                       @RequestParam(required = false) Long manufacturer,
                                       @RequestParam(required = false) Long size,
                                       @RequestParam(required = false) Long category){
        return bikeService.getAllBikes(model, manufacturer, size, category);
    }

    @GetMapping("/{id}")
    public BikeResponse getBikeById(@PathVariable long id){
        return bikeService.getBikeById(id);
    }

    @PostMapping()
    public BikeResponse addBike(@RequestBody BikeRequest request){
        return bikeService.addBike(request);
    }

    @PutMapping("/{id}")
    public BikeResponse updateBike(@PathVariable long id, @RequestBody Bike bike){
        throw new RuntimeException("Not implemented yet");
    }

    @DeleteMapping("/{id}")
    public void removeBike(@PathVariable long id){
        bikeService.removeBike(id);
    }
}
