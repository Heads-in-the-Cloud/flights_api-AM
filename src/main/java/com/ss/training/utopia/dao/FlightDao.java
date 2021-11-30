package com.ss.training.utopia.dao;

import com.ss.training.utopia.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {

}
