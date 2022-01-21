package com.ss.training.utopia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "airport")
public class Airport {

    @Id
    @NotNull
    @Column(name = "iata_id")
    private String id;

    @NotBlank
    @Column(name = "city")
    private String city;
}
