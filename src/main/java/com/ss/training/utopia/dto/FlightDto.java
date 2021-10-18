package com.ss.training.utopia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
    private Integer id;
    private Integer route;
    private Integer airplane;
    private LocalDateTime dateTime;
    private Integer reservedSeats;
    private Float seatPrice;
}
