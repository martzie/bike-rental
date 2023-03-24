package com.martzie.bikerental.bike.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String manufacturer;

    @OneToMany(mappedBy = "manufacturer", orphanRemoval = true)
    private Set<Model> models = new HashSet<>();

    public void addModel(Model model){
        models.add(model);
    }

    public void removeModel(Model model){
        models.remove(model);
    }
}
