package com.ss.training.utopia.dao;

import com.ss.training.utopia.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDao extends JpaRepository<Route, Integer> {

}
