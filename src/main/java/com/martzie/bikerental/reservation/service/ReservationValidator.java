package com.martzie.bikerental.reservation.service;

import com.martzie.bikerental.bike.repository.BikeRepository;
import com.martzie.bikerental.client.repository.ClientRepository;
import com.martzie.bikerental.reservation.controller.dto.ReservationRequest;
import com.martzie.bikerental.reservation.repository.ReservationItemRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
public class ReservationValidator implements ConstraintValidator<ValidReservation, ReservationRequest> {

    private final ClientRepository clientRepository;
    private final BikeRepository bikeRepository;
    private final ReservationItemRepository reservationItemRepository;

    @Override
    public void initialize(ValidReservation constraintAnnotation) {
    }

    @Override
    public boolean isValid(ReservationRequest request, ConstraintValidatorContext context) {
        LocalDate startDate = request.getStartDate();
        LocalDate endDate = request.getEndDate();
        List<Long> bikeIds = request.getBikeId();
        return !startDate.isBefore(LocalDate.now())
                && !endDate.isBefore(LocalDate.now())
                && !endDate.isBefore(startDate)
                && Period.between(startDate, endDate).getDays() <= 20
                && clientRepository.existsById(request.getClientId())
                && bikeRepository.findByIdIn(bikeIds).size() == bikeIds.size()
                && reservationAvailable(request);
    }

    private boolean reservationAvailable(ReservationRequest request) {
        return !request.getBikeId().stream()
        .allMatch(bike->reservationItemRepository.existsBikeReservation(bike, request.getStartDate(), request.getEndDate()));
    }
}
