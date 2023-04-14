package com.martzie.bikerental.reservation.service;

import com.martzie.bikerental.bike.model.Bike;
import com.martzie.bikerental.bike.repository.BikeRepository;
import com.martzie.bikerental.client.exception.ClientNotFoundException;
import com.martzie.bikerental.client.model.Client;
import com.martzie.bikerental.client.repository.ClientRepository;
import com.martzie.bikerental.reservation.controller.dto.ReservationRequest;
import com.martzie.bikerental.reservation.controller.dto.ReservationResponse;
 import com.martzie.bikerental.reservation.model.Reservation;
import com.martzie.bikerental.reservation.model.ReservationItem;
import com.martzie.bikerental.reservation.model.Status;
import com.martzie.bikerental.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final BikeRepository bikeRepository;
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;


    public ReservationResponse createReservation(ReservationRequest request) {
        Client client = getClient(request);
        int duration = Period.between(request.getStartDate(), request.getEndDate()).getDays() +1;
        int discount = calculateDiscount(duration);
        List<Bike> bikes = bikeRepository.findByIdIn(request.getBikeId());
        Set<ReservationItem> reservationItems = getReservationItems(duration, discount, bikes);
        BigDecimal totalCost = getTotalCost(reservationItems);

        Reservation reservation = new Reservation.ReservationBuilder()
                .client(client)
                .status(Status.CREATED)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .discountPercentage(discount)
                .items(reservationItems)
                .totalCost(totalCost)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();

        Reservation savedReservation = reservationRepository.save(reservation);

        return new ReservationResponse(savedReservation.getId(),
                savedReservation.getReservationItems().stream()
                        .map(ReservationItem::getId)
                        .collect(Collectors.toList()),
                savedReservation.getStartDate(),
                savedReservation.getEndDate(), totalCost);
    }

    private static BigDecimal getTotalCost(Set<ReservationItem> reservationItems) {
        return reservationItems.stream()
                .map(ReservationItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Set<ReservationItem> getReservationItems(int duration, int discount, List<Bike> bikes) {
        return bikes.stream()
                .map(bike -> ReservationItem.builder()
                        .bike(bike)
                        .price(getBikePrice(bike, discount, duration))
                        .build())
                .collect(Collectors.toSet());
    }

    private BigDecimal getBikePrice(Bike bike, int discount, int duration) {
        return bike.getModel().getPrice()
                .multiply(BigDecimal.valueOf(100-discount))
                .movePointLeft(2)
                .multiply(BigDecimal.valueOf(duration));
    }

    private Client getClient(ReservationRequest request) {
        long clientId = request.getClientId();
        return clientRepository.findById(clientId).orElseThrow(()-> new ClientNotFoundException(clientId));
    }

    private int calculateDiscount(int duration){
        if (duration > 5) {
            return 10;
        } else if (duration > 3) {
            return  5;
        }
        return 0;
    }

}
