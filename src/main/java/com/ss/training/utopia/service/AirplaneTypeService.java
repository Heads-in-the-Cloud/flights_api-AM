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
     * @param dao DAO object to use
     */
    public AirplaneTypeService(AirplaneTypeDao dao) {
        this.dao = dao;
    }

    /**
     * Create an AirplaneType from DTO object
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
     * @return list of AirplaneTypes
     */
    public List<AirplaneType> getAll() {
        return dao.findAll();
    }

    /**
     * Get by ID
     * @param id ID to search for
     * @return AirplaneType found
     */
    public AirplaneType getById(Integer id) {
        Optional<AirplaneType> AirplaneType = dao.findById(id);
        if (AirplaneType.isEmpty())
            throw new SQLDoesNotExistException("AirplaneType", String.valueOf(id));
        return AirplaneType.get();
    }

    /**
     * Insert new AirplaneType
     * @param insert AirplaneType to insert
     */
    public AirplaneType add(AirplaneTypeDto insert) {
        AirplaneType AirplaneType = dtoToEntity(insert);
        if (insert.getId() != null && dao.existsById(AirplaneType.getId()))
            throw new SQLAlreadyExistsException("AirplaneType", String.valueOf(AirplaneType.getId()));
        return dao.save(AirplaneType);
    }

    /**
     * Update an existing AirplaneType
     * @param insert AirplaneType to update
     */
    public void update(AirplaneTypeDto insert) {
        AirplaneType AirplaneType = dtoToEntity(insert);
        if (!dao.existsById(AirplaneType.getId()))
            throw new SQLDoesNotExistException("AirplaneType", String.valueOf(AirplaneType.getId()));
        dao.save(AirplaneType);
    }

    /**
     * Delete a given AirplaneType
     * @param id ID of AirplaneType to delete
     */
    public void delete(Integer id) {
        Optional<AirplaneType> AirplaneType = dao.findById(id);
        if (AirplaneType.isEmpty())
            throw new SQLDoesNotExistException("AirplaneType", String.valueOf(id));
        dao.delete(AirplaneType.get());
    }
}
