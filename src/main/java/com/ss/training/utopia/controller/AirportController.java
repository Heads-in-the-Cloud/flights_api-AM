package com.ss.training.utopia.controller;

import com.ss.training.utopia.entity.Airport;
import com.ss.training.utopia.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

    // construction
    private final AirportService service;
    public AirportController(AirportService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = service.getAll();
        if (airports.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(airports);
    }

}
