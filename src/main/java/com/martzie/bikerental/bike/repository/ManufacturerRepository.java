package com.martzie.bikerental.bike.repository;

import com.martzie.bikerental.bike.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    boolean existsByManufacturerIgnoreCase(String manufacturer);
}
