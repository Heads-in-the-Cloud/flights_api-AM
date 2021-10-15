package com.ss.training.utopia.dao;

import com.ss.training.utopia.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneDao extends JpaRepository<Airplane, Integer> {

}
