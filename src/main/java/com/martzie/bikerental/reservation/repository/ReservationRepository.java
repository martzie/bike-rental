package com.martzie.bikerental.reservation.repository;

import com.martzie.bikerental.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
