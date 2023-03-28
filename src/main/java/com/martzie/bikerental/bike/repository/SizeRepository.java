package com.martzie.bikerental.bike.repository;

import com.martzie.bikerental.bike.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size, Long> {

    boolean existsBySizeIgnoreCase(String size);

    List<Size> findByIdIn(List<Long> ids);

}
