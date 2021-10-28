package com.ss.training.utopia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class FlightControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFlightsGetAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
