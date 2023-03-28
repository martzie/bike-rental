package com.martzie.bikerental.bike.service;

import com.martzie.bikerental.bike.controller.converter.CategoryConverter;
import com.martzie.bikerental.bike.controller.dto.CategoryRequest;
import com.martzie.bikerental.bike.controller.dto.CategoryResponse;
import com.martzie.bikerental.bike.exception.CategoryAlreadyExistException;
import com.martzie.bikerental.bike.exception.CategoryNotFoundException;
import com.martzie.bikerental.bike.model.Category;
import com.martzie.bikerental.bike.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        return CategoryConverter.mapToCategoryResponses(allCategories);
    }

    public CategoryResponse getCategoryById(long id) {
        Category category = findById(id);
        return CategoryConverter.mapToCategoryResponse(category);
    }

    public List<CategoryResponse> getCategoryByPhrase(String search) {
        List<Category> categoryByPhrase = categoryRepository.findByCategoryContaining(search.toLowerCase());
        return CategoryConverter.mapToCategoryResponses(categoryByPhrase);
    }

    @Transactional
    public CategoryResponse addCategory(CategoryRequest request) {
        checkCategory(request.category());
        Category persistentCategory =
                categoryRepository.save(CategoryConverter.mapToCategoryEntity(request));
        return CategoryConverter.mapToCategoryResponse(persistentCategory);
    }

    private void checkCategory(String category) {
        if (categoryRepository.existsByCategoryIgnoreCase(category)) {
            throw new CategoryAlreadyExistException();
        }
    }

    private Category findById(long id){
        return categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
    }

    @Transactional
    public void removeCategory(long id) {
        Category categoryToDelete = findById(id);
        categoryRepository.delete(categoryToDelete);
    }
}
