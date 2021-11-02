package com.ss.training.utopia.service;

import com.ss.training.utopia.Exception.SQLAlreadyExistsException;
import com.ss.training.utopia.Exception.SQLDoesNotExistException;
import com.ss.training.utopia.dao.AirplaneDao;
import com.ss.training.utopia.dao.FlightDao;
import com.ss.training.utopia.dao.RouteDao;
import com.ss.training.utopia.dto.FlightDto;
import com.ss.training.utopia.entity.Airplane;
import com.ss.training.utopia.entity.Flight;
import com.ss.training.utopia.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    // vars
    private final FlightDao dao;
    private final AirplaneDao adao;
    private final RouteDao rdao;

    /**
     * Constructor
     *
     * @param dao  main DAO for Flights
     * @param rdao child DAO for Routes
     * @param adao child DAO for Airplanes
     */
    public FlightService(FlightDao dao, RouteDao rdao, AirplaneDao adao) {
        this.dao = dao;
        this.adao = adao;
        this.rdao = rdao;
    }

    /**
     * Create a Flight from DTO object
     *
     * @param dto DTO to construct from
     * @return Flight created
     */
    public Flight dtoToEntity(FlightDto dto) {
        // check Route and Airplane exist
        Optional<Airplane> airplane = adao.findById(dto.getAirplane());
        Optional<Route> route = rdao.findById(dto.getRoute());
        if (airplane.isEmpty())
            throw new SQLDoesNotExistException("Airplane", String.valueOf(dto.getAirplane()));
        if (route.isEmpty())
            throw new SQLDoesNotExistException("Route", String.valueOf(dto.getRoute()));

        // build Flight
        return Flight.builder()
            .id(dto.getId())
            .routeId(route.get())
            .airplane(airplane.get())
            .reservedSeats(dto.getReservedSeats())
            .dateTime(dto.getDateTime())
            .seatPrice(dto.getSeatPrice())
            .build();
    }

    /**
     * Get all Flights
     *
     * @return list of flights
     */
    public List<Flight> getAll() {
        return dao.findAll();
    }

    /**
     * Find flight by ID
     *
     * @param id ID to search by
     * @return Flight found
     */
    public Flight getById(Integer id) {
        Optional<Flight> flight = dao.findById(id);
        if (flight.isEmpty())
            throw new SQLDoesNotExistException("Flight", String.valueOf(id));
        return flight.get();
    }

    /**
     * Add a flight from a DTO
     *
     * @param insert DTO to insert
     * @return copy of the inserted Flight
     */
    public Flight add(FlightDto insert) {
        Flight flight = dtoToEntity(insert);
        if (flight.getId() != null && dao.existsById(flight.getId()))
            throw new SQLAlreadyExistsException("Flight", String.valueOf(flight.getId()));
        return dao.save(flight);
    }

    /**
     * Update a flight
     *
     * @param insert DTO to update with
     */
    public void update(FlightDto insert) {
        Flight flight = dtoToEntity(insert);
        if (!dao.existsById(flight.getId()))
            throw new SQLDoesNotExistException("Flight", String.valueOf(flight.getId()));
        dao.save(flight);
    }

    /**
     * Delete an existing Flight
     *
     * @param id ID of flight to remove
     */
    public void delete(Integer id) {
        Optional<Flight> flight = dao.findById(id);
        if (flight.isEmpty())
            throw new SQLDoesNotExistException("Route", String.valueOf(id));
        dao.delete(flight.get());
    }
}
