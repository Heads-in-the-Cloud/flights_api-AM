package com.ss.training.utopia.controller;

import com.ss.training.utopia.dto.AirportDto;
import com.ss.training.utopia.entity.Airport;
import com.ss.training.utopia.service.AirportService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

    // construction
    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = service.getAll();
        if (airports.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(airports);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Airport> addAirport(@RequestBody AirportDto airportDto) {
        // add new
        Airport airport = service.add(airportDto);
        URI uri = URI.create("/api/v1/airports/" + airport.getId());
        return ResponseEntity.created(uri).body(airport);
    }

    @GetMapping("/{iataId}")
    public ResponseEntity<Airport> getAirportById(@PathVariable String iataId) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(iataId)));
    }

    @PutMapping("/{iataId}")
    public ResponseEntity<Airport> updateAirport(@RequestBody AirportDto airportDto) {
        service.update(airportDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{iataId}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String iataId) {
        service.delete(iataId);
        return ResponseEntity.noContent().build();
    }
}
