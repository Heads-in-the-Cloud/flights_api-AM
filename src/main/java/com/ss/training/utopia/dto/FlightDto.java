package com.ss.training.utopia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Integer id;

    @NotBlank(message = "Flights must provide a route identifier.")
    private Integer route;

    @NotBlank(message = "Flights must provide an airplane identifier.")
    private Integer airplane;

    @NotBlank(message = "Flights must provide a departure date and time.")
    private LocalDateTime dateTime;

    @NotBlank(message = "Flights must have a number of reserved seats.")
    private Integer reservedSeats;

    @NotBlank(message = "Flights must have a price per seat.")
    private Float seatPrice;
}
