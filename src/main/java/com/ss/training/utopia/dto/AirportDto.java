package com.ss.training.utopia.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportDto {

    @Size(min=3, max=3)
    @NotBlank
    private String iataId;

    @NotBlank
    private String city;
}
