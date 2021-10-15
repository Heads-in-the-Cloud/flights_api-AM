package com.ss.training.utopia.controller;

import com.ss.training.utopia.entity.Route;
import com.ss.training.utopia.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
