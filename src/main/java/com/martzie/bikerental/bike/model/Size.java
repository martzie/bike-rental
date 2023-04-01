package com.martzie.bikerental.bike.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String size;

    @ManyToMany(mappedBy = "sizes")
    private List<Model> models = new ArrayList<>();
}
