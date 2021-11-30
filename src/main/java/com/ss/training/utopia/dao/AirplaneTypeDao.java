package com.ss.training.utopia.dao;

import com.ss.training.utopia.entity.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeDao extends JpaRepository<AirplaneType, Integer> {

}
