package com.martzie.bikerental.bike.controller;

import com.martzie.bikerental.bike.model.Category;
import com.martzie.bikerental.bike.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/all")
    public List<Category> getActiveCategories(){
        return getAllCategories().stream()
                .filter(Category::isActive)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping()
    public List<Category> getCategoryByPhrase(@RequestParam String search){
        return categoryService.getCategoryByPhrase(search);
    }

    @PostMapping()
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

}
