package com.martzie.bikerental.bike.repository;

import com.martzie.bikerental.bike.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByCategoryContaining(String phrase);
    boolean existsByCategoryIgnoreCase(String category);
}
