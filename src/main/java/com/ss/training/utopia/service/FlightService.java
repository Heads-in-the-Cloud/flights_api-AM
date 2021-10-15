package com.ss.training.utopia.service;

import com.ss.training.utopia.dao.FlightDao;
import com.ss.training.utopia.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    // constructor
    private final FlightDao dao;
    public FlightService(FlightDao dao) {
        this.dao = dao;
    }

    // get all
    public List<Flight> getAll() { return dao.findAll(); }

    // get by ID
    public Optional<Flight> getById(Integer id) { return dao.findById(id); }

    // add
    public void add(Flight insert) { dao.save(insert); }

    // update
    public void update(Flight insert) { dao.save(insert); }

    // remove
    public void delete(Integer id) { dao.findById(id).ifPresent(dao::delete); }
}
