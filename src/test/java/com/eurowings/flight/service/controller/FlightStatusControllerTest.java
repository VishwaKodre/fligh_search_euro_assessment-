package com.eurowings.flight.service.controller;

import com.eurowings.flight.service.model.Flight;
import com.eurowings.flight.service.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class FlightStatusControllerTest {
    @Mock
    FlightService flightService;
    @InjectMocks
    FlightStatusController flightStatusController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFlightById() {
        when(flightService.getFlightById(anyString())).thenReturn(new Flight());

        ResponseEntity<Flight> result = flightStatusController.getFlightById("id", "v1");
        assertNotNull(result);
    }

    @Test
    void testGetAllFlights() {
        when(flightService.getAllFlights()).thenReturn(List.of(new Flight()));

        ResponseEntity<List<Flight>> result = flightStatusController.getAllFlights("v1");
        assertNotNull(result);
    }
}