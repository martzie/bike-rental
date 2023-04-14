package com.martzie.bikerental.reservation.service;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ReservationValidator.class)
public @interface ValidReservation {

    String message () default "Reservation contains not allowed values";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload () default{};
}
