package com.ss.training.utopia.controller;

import com.ss.training.utopia.dto.AirplaneTypeDto;
import com.ss.training.utopia.entity.AirplaneType;
import com.ss.training.utopia.service.AirplaneTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airplaneTypes")
public class AirplaneTypeController {

    // construction
    private final AirplaneTypeService service;

    public AirplaneTypeController(AirplaneTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AirplaneType>> getAllAirplaneTypes() {
        List<AirplaneType> airplaneTypes = service.getAll();
        if (airplaneTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(airplaneTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirplaneType> getAirplaneTypeById(@PathVariable int id) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<AirplaneType> addAirplaneType(@RequestBody AirplaneTypeDto airplaneTypeDto) {
        AirplaneType airplaneType = service.add(airplaneTypeDto);
        URI uri = URI.create("/api/v1/airplaneTypes/" + airplaneType.getId());
        return ResponseEntity.created(uri).body(airplaneType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirplaneType> updateAirplaneType(@RequestBody AirplaneTypeDto airplaneTypeDto) {
        service.update(airplaneTypeDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
