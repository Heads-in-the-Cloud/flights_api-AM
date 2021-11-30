package com.ss.training.utopia.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportDto {

    @Size(min = 3, max = 3, message = "Airport IDs must be exactly 3 characters long.")
    @NotBlank(message = "Airports must be provided an ID.")
    private String iataId;

    @NotBlank(message = "Airports must be provided a city name.")
    @Size(max = 45, message = "Airport names cannot be more than 45 characters long.")
    private String city;
}
