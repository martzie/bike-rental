package com.martzie.bikerental.reservation.model;

import com.martzie.bikerental.bike.model.Bike;
import com.martzie.bikerental.reservation.model.Reservation.ReservationBuilder;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
public class ReservationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Bike bike;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private BigDecimal price;

    @Tolerate
    public ReservationItem() {
    }

    public static class ReservationItemListBuilder {

        public Set<ReservationItem> items = new HashSet<>();
        private ReservationBuilder reservationBuilder;

        public ReservationItemListBuilder(Reservation.ReservationBuilder reservationBuilder) {
            this.reservationBuilder = reservationBuilder;
        }
    }
}
