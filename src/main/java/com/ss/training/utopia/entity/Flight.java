package com.ss.training.utopia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
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
}
