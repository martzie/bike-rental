package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.model.Bike;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    @GetMapping("/bikes")
    public List<Bike> getAllBikes(){
        throw new RuntimeException("Not implemented yet");
    }

    @PostMapping("/bikes")
    public Bike addBike(@RequestBody Bike bike){
        throw new RuntimeException("Not implemented yet");
    }

    @PutMapping("/bikes/{id}")
    public Bike updateBike(@PathVariable long id, @RequestBody Bike bike){
        throw new RuntimeException("Not implemented yet");
    }
}
