package com.ss.training.utopia.service;

import com.ss.training.utopia.dao.AirplaneDao;
import com.ss.training.utopia.entity.Airplane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {
    // construction
    private final AirplaneDao dao;
    public AirplaneService(AirplaneDao dao) {
        this.dao = dao;
    }

    // get all
    public List<Airplane> getAll() { return dao.findAll(); }

    // get by ID
    public Optional<Airplane> getById(Integer id) { return dao.findById(id); }

    // add
    public void add(Airplane insert) { dao.save(insert); }

    // update
    public void update(Airplane insert) { dao.save(insert); }

    // remove
    public void delete(Integer id) { dao.findById(id).ifPresent(dao::delete); }
}
