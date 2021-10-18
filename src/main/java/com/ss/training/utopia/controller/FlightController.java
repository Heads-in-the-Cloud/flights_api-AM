package com.ss.training.utopia.controller;

import com.ss.training.utopia.dto.FlightDto;
import com.ss.training.utopia.entity.Flight;
import com.ss.training.utopia.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    // construction
    private final FlightService service;
    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = service.getAll();
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable int id) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody FlightDto flightDto) {
        Flight flight = service.add(flightDto);
        URI uri = URI.create("/api/v1/flights/" + flight.getId());
        return ResponseEntity.created(uri).body(flight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@RequestBody FlightDto flightDto) {
        service.update(flightDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
