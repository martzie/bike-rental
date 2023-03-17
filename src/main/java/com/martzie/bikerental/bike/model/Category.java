package com.martzie.bikerental.bike.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    @Column(unique = true)
    private String category;
    private boolean isActive;

    public void setCategory(String category) {
        this.category = category.toLowerCase();
    }
}
