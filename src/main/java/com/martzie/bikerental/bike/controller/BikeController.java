package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.model.Bike;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Bikes")
@RequestMapping("/bikes")
public class BikeController {

    @GetMapping()
    public List<Bike> getAllBikes(){
        throw new RuntimeException("Not implemented yet");
    }

    @PostMapping()
    public Bike addBike(@RequestBody Bike bike){
        throw new RuntimeException("Not implemented yet");
    }

    @PutMapping("{id}")
    public Bike updateBike(@PathVariable long id, @RequestBody Bike bike){
        throw new RuntimeException("Not implemented yet");
    }
}
