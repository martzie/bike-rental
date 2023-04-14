package com.martzie.bikerental.reservation.model;

import com.martzie.bikerental.client.model.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
//@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Client client;

    @OneToMany(mappedBy = "reservation", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<ReservationItem> reservationItems = new HashSet<>();

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime created;
    private LocalDateTime updated;
    private long discountPercentage;
    private BigDecimal totalCost;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Tolerate
    Reservation() {
    }

    public static final class ReservationBuilder {
        private Client client;
        private LocalDate startDate;
        private LocalDate endDate;
        private LocalDateTime created;
        private LocalDateTime updated;
        private long discountPercentage;
        private Status status;
        private ReservationItem.ReservationItemListBuilder itemListBuilder;
        private BigDecimal totalCost;

        public ReservationBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public ReservationBuilder startDate(LocalDate startDate){
            this.startDate = startDate;
            return this;
        }

        public ReservationBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public ReservationBuilder created(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public ReservationBuilder updated(LocalDateTime updated) {
            this.updated = updated;
            return this;
        }

        public ReservationBuilder discountPercentage(long discount){
            this.discountPercentage = discount;
            return this;
        }

        public ReservationBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public ReservationBuilder totalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public ReservationBuilder items(Set<ReservationItem> items){
            this.itemListBuilder = new ReservationItem.ReservationItemListBuilder(this);
            this.itemListBuilder.items = items;
            return this;
        }

        public Reservation build(){
            Reservation reservation = new Reservation();
            reservation.setClient(this.client);
            reservation.setStartDate(this.startDate);
            reservation.setEndDate(this.endDate);
            reservation.setCreated(this.created);
            reservation.setUpdated(this.updated);
            reservation.setDiscountPercentage(this.discountPercentage);
            reservation.setStatus(this.status);
            reservation.setTotalCost(this.totalCost);

            Set<ReservationItem> items = this.itemListBuilder.items;
            for (ReservationItem item : items) {
                item.setReservation(reservation);
            }
            reservation.setReservationItems(items);
            return reservation;
        }

    }
}
