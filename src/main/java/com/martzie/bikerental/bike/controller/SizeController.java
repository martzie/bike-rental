package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.controller.dto.SizeRequest;
import com.martzie.bikerental.bike.controller.dto.SizeResponse;
import com.martzie.bikerental.bike.service.SizeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizes")
@Tag(name = "Sizes")
@RequiredArgsConstructor
public class SizeController {

    private final SizeService sizeService;

    @PostMapping
    public SizeResponse addSize(@RequestBody SizeRequest request){
        return sizeService.addSize(request);
    }

    @GetMapping("/{id}")
    public SizeResponse getSizeById(@PathVariable long id){
        return sizeService.getSizeById(id);
    }

    @GetMapping
    public List<SizeResponse> getAllSizes(){
        return sizeService.getAllSizes();
    }

    @DeleteMapping("/{id}")
    public void removeSize(@PathVariable long id){
        sizeService.removeSize(id);
    }
}
