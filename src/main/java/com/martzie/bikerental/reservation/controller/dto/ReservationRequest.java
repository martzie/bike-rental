package com.martzie.bikerental.reservation.controller.dto;

import com.martzie.bikerental.reservation.service.ValidReservation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ValidReservation
public class ReservationRequest  {

    private long clientId;
    private List<Long> bikeId;
    private LocalDate startDate;
    private LocalDate endDate;

}
