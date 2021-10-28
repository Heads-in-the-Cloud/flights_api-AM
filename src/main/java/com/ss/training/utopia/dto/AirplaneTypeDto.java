package com.ss.training.utopia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneTypeDto {

    private Integer id;

    @NotBlank(message = "Must supply a plane capacity.")
    @Min(value = 1, message = "Plane capacity must be between 1 and 1000.")
    @Max(value = 1000, message = "Plane capacity must be between 1 and 1000.")
    private Integer maxCapacity;
}
