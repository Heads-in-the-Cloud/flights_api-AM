package com.ss.training.utopia.controller;

import com.ss.training.utopia.dto.AirplaneDto;
import com.ss.training.utopia.entity.Airplane;
import com.ss.training.utopia.service.AirplaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airplanes")
public class AirplaneController {

    // construction
    private final AirplaneService service;
    public AirplaneController(AirplaneService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
        List<Airplane> airplanes = service.getAll();
        if (airplanes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(airplanes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable int id) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<Airplane> addAirplane(@RequestBody AirplaneDto airplaneDto) {
        Airplane airplane = service.add(airplaneDto);
        URI uri = URI.create("/api/v1/airplanes/" + airplane.getId());
        return ResponseEntity.created(uri).body(airplane);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airplane> updateAirplane(@RequestBody AirplaneDto airplaneDto) {
        service.update(airplaneDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
