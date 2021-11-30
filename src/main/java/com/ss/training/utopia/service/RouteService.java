package com.ss.training.utopia.service;

import com.ss.training.utopia.Exception.SQLAlreadyExistsException;
import com.ss.training.utopia.Exception.SQLDoesNotExistException;
import com.ss.training.utopia.dao.AirportDao;
import com.ss.training.utopia.dao.RouteDao;
import com.ss.training.utopia.dto.RouteDto;
import com.ss.training.utopia.entity.Airport;
import com.ss.training.utopia.entity.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    // vars
    private final RouteDao dao;
    private final AirportDao adao;

    /**
     * Constructor
     *
     * @param dao route Dao to use
     */
    public RouteService(RouteDao dao, AirportDao adao) {
        this.dao = dao;
        this.adao = adao;
    }

    /**
     * Create a Route from DTO object
     *
     * @param dto DTO to construct from
     * @return the Route created
     */
    public Route dtoToEntity(RouteDto dto) {
        // check Airports exist for route
        Optional<Airport> origin = adao.findById(dto.getOrigin());
        Optional<Airport> destination = adao.findById(dto.getDestination());
        if (origin.isEmpty())
            throw new SQLDoesNotExistException("Airport", dto.getOrigin());
        if (destination.isEmpty())
            throw new SQLDoesNotExistException("Airport", dto.getDestination());

        // build route
        return Route.builder()
            .id(dto.getId())
            .origin(origin.get())
            .destination(destination.get())
            .build();
    }

    /**
     * Get all Routes
     *
     * @return list of routes
     */
    public List<Route> getAll() {
        return dao.findAll();
    }

    /**
     * Find a route by ID
     *
     * @param id ID to search by
     * @return Route found
     */
    public Route getById(Integer id) {
        Optional<Route> route = dao.findById(id);
        if (route.isEmpty())
            throw new SQLDoesNotExistException("Route", String.valueOf(id));
        return route.get();
    }

    /**
     * Add a route from a DTO
     *
     * @param insert DTO to insert
     * @return copy of the inserted Route
     */
    public Route add(RouteDto insert) {
        Route route = dtoToEntity(insert);
        if (route.getId() != null && dao.existsById(route.getId()))
            throw new SQLAlreadyExistsException("Route", String.valueOf(route.getId()));
        return dao.save(route);
    }

    /**
     * Update an existing Route
     *
     * @param insert route to update
     */
    public void update(RouteDto insert) {
        Route route = dtoToEntity(insert);
        if (!dao.existsById(route.getId()))
            throw new SQLDoesNotExistException("Route", String.valueOf(route.getId()));
        dao.save(route);
    }

    /**
     * Delete an existing Route
     *
     * @param id route ID to delete
     */
    public void delete(Integer id) {
        Optional<Route> route = dao.findById(id);
        if (route.isEmpty())
            throw new SQLDoesNotExistException("Route", String.valueOf(id));
        dao.delete(route.get());
    }
}
