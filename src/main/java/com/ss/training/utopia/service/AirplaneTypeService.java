package com.ss.training.utopia.service;

import com.ss.training.utopia.Exception.SQLAlreadyExistsException;
import com.ss.training.utopia.Exception.SQLDoesNotExistException;
import com.ss.training.utopia.dao.AirplaneTypeDao;
import com.ss.training.utopia.dto.AirplaneTypeDto;
import com.ss.training.utopia.entity.AirplaneType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneTypeService {

    // vars
    private final AirplaneTypeDao dao;

    /**
     * Constructor
     *
     * @param dao DAO object to use
     */
    public AirplaneTypeService(AirplaneTypeDao dao) {
        this.dao = dao;
    }

    /**
     * Create an AirplaneType from DTO object
     *
     * @param dto DTO to construct from
     * @return the AirplaneType created
     */
    public AirplaneType dtoToEntity(AirplaneTypeDto dto) {
        // build AirplaneType
        return AirplaneType.builder()
            .id(dto.getId())
            .maxCapacity(dto.getMaxCapacity())
            .build();
    }

    /**
     * Get all AirplaneTypes
     *
     * @return list of AirplaneTypes
     */
    public List<AirplaneType> getAll() {
        return dao.findAll();
    }

    /**
     * Get by ID
     *
     * @param id ID to search for
     * @return AirplaneType found
     */
    public AirplaneType getById(Integer id) {
        Optional<AirplaneType> airplaneType = dao.findById(id);
        if (airplaneType.isEmpty())
            throw new SQLDoesNotExistException("AirplaneType", String.valueOf(id));
        return airplaneType.get();
    }

    /**
     * Insert new AirplaneType
     *
     * @param insert AirplaneType to insert
     */
    public AirplaneType add(AirplaneTypeDto insert) {
        AirplaneType airplaneType = dtoToEntity(insert);
        if (insert.getId() != null && dao.existsById(airplaneType.getId()))
            throw new SQLAlreadyExistsException("AirplaneType", String.valueOf(airplaneType.getId()));
        return dao.save(airplaneType);
    }

    /**
     * Update an existing AirplaneType
     *
     * @param insert AirplaneType to update
     */
    public void update(AirplaneTypeDto insert) {
        AirplaneType airplaneType = dtoToEntity(insert);
        if (!dao.existsById(airplaneType.getId()))
            throw new SQLDoesNotExistException("AirplaneType", String.valueOf(airplaneType.getId()));
        dao.save(airplaneType);
    }

    /**
     * Delete a given AirplaneType
     *
     * @param id ID of AirplaneType to delete
     */
    public void delete(Integer id) {
        Optional<AirplaneType> airplaneType = dao.findById(id);
        if (airplaneType.isEmpty())
            throw new SQLDoesNotExistException("AirplaneType", String.valueOf(id));
        dao.delete(airplaneType.get());
    }
}
