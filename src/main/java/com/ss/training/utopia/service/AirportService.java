package com.ss.training.utopia.service;

import com.ss.training.utopia.exception.SQLAlreadyExistsException;
import com.ss.training.utopia.exception.SQLDoesNotExistException;
import com.ss.training.utopia.dao.AirportDao;
import com.ss.training.utopia.dto.AirportDto;
import com.ss.training.utopia.entity.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    // vars
    private final AirportDao dao;
    private final String objectType;

    /**
     * Constructor
     *
     * @param dao the Airport dao to use
     */
    public AirportService(AirportDao dao) {
        this.dao = dao;
        objectType = "Airport";
    }

    /**
     * Converts a DTO object to an Entity
     *
     * @param dto DTO object to convert
     * @return the resulting airport object
     */
    public Airport dtoToEntity(AirportDto dto) {
        return Airport.builder()
            .id(dto.getIataId())
            .city(dto.getCity())
            .build();
    }

    /**
     * Get all Airports
     *
     * @return list of airports
     */
    public List<Airport> getAll() {
        return dao.findAll();
    }

    /**
     * Insert a new Airport
     *
     * @param insert Airport object to insert
     * @return Copy of inserted object
     */
    public Airport add(AirportDto insert) {
        Airport airport = dtoToEntity(insert);
        if (dao.existsById(insert.getIataId()))
            throw new SQLAlreadyExistsException(objectType, airport.getId());
        return dao.save(airport);
    }

    /**
     * Find airport by ID
     *
     * @param iataId ID to search for
     * @return Optional Airport result
     */
    public Airport getById(String iataId) {
        Optional<Airport> airport = dao.findById(iataId);
        if (airport.isEmpty())
            throw new SQLDoesNotExistException(objectType, iataId);
        return airport.get();
    }

    /**
     * Update an existing airport
     *
     * @param insert Airport object to update with
     */
    public void update(AirportDto insert) {
        Airport airport = dtoToEntity(insert);
        if (!dao.existsById(airport.getId()))
            throw new SQLDoesNotExistException(objectType, airport.getId());
        dao.save(airport);
    }

    /**
     * Delete an airport
     *
     * @param iataId ID to delete
     */
    public void delete(String iataId) {
        Optional<Airport> airport = dao.findById(iataId);
        if (airport.isEmpty())
            throw new SQLDoesNotExistException(objectType, iataId);
        dao.delete(airport.get());
    }

}
