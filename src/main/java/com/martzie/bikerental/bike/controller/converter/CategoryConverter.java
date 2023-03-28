package com.martzie.bikerental.bike.controller.converter;

import com.martzie.bikerental.bike.controller.dto.CategoryRequest;
import com.martzie.bikerental.bike.controller.dto.CategoryResponse;
import com.martzie.bikerental.bike.model.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryConverter {

    public static Category mapToCategoryEntity(CategoryRequest request){
        Category category = new Category();
        category.setCategory(request.category());
        return category;
    }

    public static List<CategoryResponse> mapToCategoryResponses(List<Category> categories){
        return categories.stream()
                .map(CategoryConverter::mapToCategoryResponse)
                .collect(Collectors.toList());
    }

    public static CategoryResponse mapToCategoryResponse(Category category){
        return new CategoryResponse(category.getId(), category.getCategory());
    }
}
