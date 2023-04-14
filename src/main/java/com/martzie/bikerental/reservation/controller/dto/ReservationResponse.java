package com.martzie.bikerental.reservation.controller.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public record ReservationResponse(long id, List<Long> reservationItems, LocalDate startDate, LocalDate endDate, BigDecimal totalPrice) {
}
