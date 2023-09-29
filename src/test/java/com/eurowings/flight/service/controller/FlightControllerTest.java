package com.eurowings.flight.service.controller;

import com.eurowings.flight.service.model.Flight;
import com.eurowings.flight.service.model.FlightStatus;
import com.eurowings.flight.service.service.FlightService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class FlightControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    @Qualifier("flightService")
    private FlightService flightService;

    // Define sample Flight data for testing
    private Flight sampleFlight;

    @BeforeEach
    public void setUp() {
        // Initialize sample Flight data
        sampleFlight = new Flight();
        sampleFlight.setId("1");
        sampleFlight.setFlightNumber("BA123");
        sampleFlight.setStatus(FlightStatus.ON_TIME);

        // Mock the FlightService behavior
        when(flightService.getFlightById("1")).thenReturn(sampleFlight);
        when(flightService.getAllFlights()).thenReturn(Collections.singletonList(sampleFlight));
    }

    @Test
    void testGetFlightById() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/flights/1"));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(sampleFlight.getId()))
                .andExpect(jsonPath("$.flightNumber").value(sampleFlight.getFlightNumber()))
                .andExpect(jsonPath("$.status").value(sampleFlight.getStatus().name()));
    }

    @Test
    void testGetAllFlights() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/flights/all"));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(sampleFlight.getId()))
                .andExpect(jsonPath("$[0].flightNumber").value(sampleFlight.getFlightNumber()))
                .andExpect(jsonPath("$[0].status").value(sampleFlight.getStatus().name()));
    }
}
