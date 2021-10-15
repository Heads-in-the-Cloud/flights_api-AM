package com.ss.training.utopia.service;

import com.ss.training.utopia.dao.AirportDao;
import com.ss.training.utopia.entity.Airport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    // constructor
    private final AirportDao dao;
    public AirportService(AirportDao dao) {
        this.dao = dao;
    }

    public List<Airport> getAll() { return dao.findAll(); }
}
