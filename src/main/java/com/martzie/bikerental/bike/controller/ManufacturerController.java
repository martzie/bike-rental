package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.controller.dto.ManufacturerRequest;
import com.martzie.bikerental.bike.controller.dto.ManufacturerResponse;
import com.martzie.bikerental.bike.service.ManufacturerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Manufacturers")
@RestController
@RequestMapping("/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @PostMapping
    private ManufacturerResponse addManufacturer(@RequestBody ManufacturerRequest request){
        return manufacturerService.addManufacturer(request);
    }

    @GetMapping("/{id}")
    private ManufacturerResponse getManufacturerById(@PathVariable long id){
        return manufacturerService.getManufacturerById(id);
    }

    @GetMapping
    private List<ManufacturerResponse> getAllManufacturers(){
        return manufacturerService.getAllManufacturers();
    }

    @DeleteMapping("/{id}")
    private void removeManufacturer(@PathVariable long id) {
        manufacturerService.removeManufacturer(id);
    }
}
