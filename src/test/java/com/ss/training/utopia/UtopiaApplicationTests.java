package com.ss.training.utopia;

import com.ss.training.utopia.controller.FlightController;
import com.ss.training.utopia.entity.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UtopiaApplicationTests {

    @Autowired
    private FlightController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
