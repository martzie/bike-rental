package com.martzie.bikerental.reservation.repository;

import com.martzie.bikerental.reservation.model.ReservationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {

    @Query("""
            select count(ri) > 0
            from ReservationItem ri
            join ri.reservation r
            join ri.bike b
            where
                b.id = :bikeId and
                r.endDate >= :startDate and
                r.startDate <= :endDate
            """)
    boolean existsBikeReservation(Long bikeId, LocalDate startDate, LocalDate endDate);
}
