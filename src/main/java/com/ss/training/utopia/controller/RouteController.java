package com.ss.training.utopia.controller;

import com.ss.training.utopia.dto.RouteDto;
import com.ss.training.utopia.entity.Route;
import com.ss.training.utopia.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {

    // construction
    private final RouteService service;
    public RouteController(RouteService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = service.getAll();
        if (routes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(routes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable int id) {
        return ResponseEntity.of(Optional.ofNullable(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<Route> addRoute(@RequestBody RouteDto routeDto) {
        Route route = service.add(routeDto);
        URI uri = URI.create("/api/v1/routes/" + route.getId());
        return ResponseEntity.created(uri).body(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@RequestBody RouteDto routeDto) {
        service.update(routeDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
