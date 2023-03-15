package com.martzie.bikerental.bike.service;

import com.martzie.bikerental.bike.exception.CategoryAlreadyExistException;
import com.martzie.bikerental.bike.exception.CategoryNotFoundException;
import com.martzie.bikerental.bike.model.Category;
import com.martzie.bikerental.bike.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
    }

    public List<Category> getCategoryByPhrase(String search) {
        return categoryRepository.findByCategoryContaining(search.toLowerCase());
    }

    public Category addCategory(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e){
            throw new CategoryAlreadyExistException();
        }
    }
}
