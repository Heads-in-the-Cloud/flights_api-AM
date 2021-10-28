package com.ss.training.utopia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {

    private Integer id;

    @NotBlank(message = "Must supply an Airplane Type.")
    private Integer airplaneType;
}
