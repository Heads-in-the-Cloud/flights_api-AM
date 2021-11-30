package com.ss.training.utopia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {

    private Integer id;

    @NotBlank(message = "Routes must have an origin Airport.")
    @Size(min = 3, max = 3, message = "Airports IDs must be exactly 3 characters.")
    private String origin;

    @NotBlank(message = "Routes must have a destination Airport.")
    @Size(min = 3, max = 3, message = "Airports IDs must be exactly 3 characters.")
    private String destination;
}
