package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.controller.dto.ModelRequest;
import com.martzie.bikerental.bike.controller.dto.ModelResponse;
import com.martzie.bikerental.bike.service.ModelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Models")
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @PostMapping()
    public ModelResponse addModel(@RequestBody ModelRequest request){
        return modelService.addModel(request);
    }

    @GetMapping("/{id}")
    public ModelResponse getModelById(@PathVariable long id){
        return modelService.getModelById(id);
    }

    @GetMapping()
    public List<ModelResponse> getAllModels(){
        return modelService.getAllBikes();
    }

    @DeleteMapping("/{id}")
    public void removeModel(@PathVariable long id){
        modelService.removeModel(id);
    }

    @PatchMapping("/{id}")
    public ModelResponse updateModel(@PathVariable long id, @RequestBody ModelRequest request){
        return modelService.updateModel(id, request);
    }
}
