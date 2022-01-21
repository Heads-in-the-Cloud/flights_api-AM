package com.ss.training.utopia.service;

import com.ss.training.utopia.exception.SQLAlreadyExistsException;
import com.ss.training.utopia.exception.SQLDoesNotExistException;
import com.ss.training.utopia.dao.AirplaneDao;
import com.ss.training.utopia.dao.AirplaneTypeDao;
import com.ss.training.utopia.dto.AirplaneDto;
import com.ss.training.utopia.entity.Airplane;
import com.ss.training.utopia.entity.AirplaneType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {

    // vars
    private final AirplaneDao dao;
    private final AirplaneTypeDao atdao;
    private final String objectType;

    /**
     * Constructor
     *
     * @param dao DAO object to use
     */
    public AirplaneService(AirplaneDao dao, AirplaneTypeDao atdao) {
        this.dao = dao;
        this.atdao = atdao;
        objectType = "Airplane";
    }

    /**
     * Create an Airplane from DTO object
     *
     * @param dto DTO to construct from
     * @return the Airplane created
     */
    public Airplane dtoToEntity(AirplaneDto dto) {
        // check airplane type exists for airplane
        Optional<AirplaneType> type = atdao.findById(dto.getAirplaneType());
        if (type.isEmpty())
            throw new SQLDoesNotExistException("Airplane Type", String.valueOf(dto.getId()));

        // build airplane
        return Airplane.builder()
            .id(dto.getId())
            .airplaneType(type.get())
            .build();
    }

    /**
     * Get all Airplanes
     *
     * @return list of airplanes
     */
    public List<Airplane> getAll() {
        return dao.findAll();
    }

    /**
     * Get by ID
     *
     * @param id ID to search for
     * @return Airplane found
     */
    public Airplane getById(Integer id) {
        Optional<Airplane> airplane = dao.findById(id);
        if (airplane.isEmpty())
            throw new SQLDoesNotExistException(objectType, String.valueOf(id));
        return airplane.get();
    }

    /**
     * Insert new Airplane
     *
     * @param insert airplane to insert
     */
    public Airplane add(AirplaneDto insert) {
        Airplane airplane = dtoToEntity(insert);
        if (insert.getId() != null && dao.existsById(airplane.getId()))
            throw new SQLAlreadyExistsException(objectType, String.valueOf(airplane.getId()));
        return dao.save(airplane);
    }

    /**
     * Update an existing Airplane
     *
     * @param insert airplane to update
     */
    public void update(AirplaneDto insert) {
        Airplane airplane = dtoToEntity(insert);
        if (!dao.existsById(airplane.getId()))
            throw new SQLDoesNotExistException(objectType, String.valueOf(airplane.getId()));
        dao.save(airplane);
    }

    /**
     * Delete a given Airplane
     *
     * @param id ID of airplane to delete
     */
    public void delete(Integer id) {
        Optional<Airplane> airplane = dao.findById(id);
        if (airplane.isEmpty())
            throw new SQLDoesNotExistException(objectType, String.valueOf(id));
        dao.delete(airplane.get());
    }
}
