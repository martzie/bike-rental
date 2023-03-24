package com.martzie.bikerental.bike.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "category")
    private final Set<Model> models = new HashSet<>();

    public void setCategory(String category) {
        this.category = category.toLowerCase();
    }

    public void addModel(Model model){
        models.add(model);
    }

    public void removeModel(Model model){
        models.remove(model);
    }
}
