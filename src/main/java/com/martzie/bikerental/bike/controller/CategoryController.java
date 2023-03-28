package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.controller.dto.CategoryRequest;
import com.martzie.bikerental.bike.controller.dto.CategoryResponse;
import com.martzie.bikerental.bike.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Categories")
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/")
    public List<CategoryResponse> getCategoryByPhrase(@RequestParam String search){
        return categoryService.getCategoryByPhrase(search);
    }

    @PostMapping
    public CategoryResponse addCategory(@RequestBody CategoryRequest request){
        return categoryService.addCategory(request);
    }

    @DeleteMapping
    public void removeCategory(@PathVariable long id){
        categoryService.removeCategory(id);
    }

}
