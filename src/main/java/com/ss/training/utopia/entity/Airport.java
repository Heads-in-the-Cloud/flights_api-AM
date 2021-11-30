package com.ss.training.utopia.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
