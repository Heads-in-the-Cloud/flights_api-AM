package com.ss.training.utopia.service;

import com.ss.training.utopia.dao.RouteDao;
import com.ss.training.utopia.entity.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    // construction
    private final RouteDao dao;
    public RouteService(RouteDao dao) { this.dao = dao; }

    public List<Route> getAll() { return dao.findAll(); }
}
