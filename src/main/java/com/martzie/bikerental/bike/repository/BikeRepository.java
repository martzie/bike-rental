package com.martzie.bikerental.bike.repository;

import com.martzie.bikerental.bike.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Query("""
            select b
            from Bike b
            join b.model m
            join m.manufacturer mf
            join m.category cat
            join b.size s
            where
                (:model is null or m.id = :model) and
                (:manufacturer is null or mf.id = :manufacturer) and
                (:category is null or cat.id = :category) and
                (:size is null or s.id = :size)
            """)
    List<Bike> findBikesByOptionalCriteria(Long model,
                                           Long manufacturer,
                                           Long size,
                                           Long category);

    List<Bike> findByIdIn(List<Long> bikesId);

}
