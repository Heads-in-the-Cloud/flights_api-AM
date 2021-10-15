package com.ss.training.utopia.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route routeId; // route_id INT

    @ManyToOne(targetEntity = Airplane.class)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane; // airplane_id INT

    @Column(name = "departure_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime; // departure_time DATETIME

    @Column(name = "reserved_seats")
    private Integer reservedSeats; // reserved_seats INT

    @Column(name = "seat_price")
    private Float seatPrice; // seat_price FLOAT

    // GET
    public Integer getId() {
        return id;
    }
    public Route getRouteId() {
        return routeId;
    }
    public Airplane getAirplane() {
        return airplane;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public Integer getReservedSeats() {
        return reservedSeats;
    }
    public Float getSeatPrice() {
        return seatPrice;
    }

    // SET
    public void setId(Integer flightId) {
        this.id = flightId;
    }
    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void setReservedSeats(Integer reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
    public void setSeatPrice(Float seatPrice) {
        this.seatPrice = seatPrice;
    }

}
