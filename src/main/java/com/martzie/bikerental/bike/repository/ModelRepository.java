package com.martzie.bikerental.bike.repository;

import com.martzie.bikerental.bike.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
