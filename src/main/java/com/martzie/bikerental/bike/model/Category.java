package com.martzie.bikerental.bike.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    @Column(unique = true)
    private String category;

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
