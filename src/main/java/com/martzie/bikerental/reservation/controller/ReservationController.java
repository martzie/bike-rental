package com.martzie.bikerental.reservation.controller;

import com.martzie.bikerental.reservation.controller.dto.ReservationRequest;
import com.martzie.bikerental.reservation.controller.dto.ReservationResponse;
import com.martzie.bikerental.reservation.service.ReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reservations")
@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping()
    public ReservationResponse addReservation(@RequestBody @Valid ReservationRequest request){
        return reservationService.createReservation(request);
    }

}
