package com.eurowings.flight.service.service;

import com.eurowings.flight.service.model.Flight;
import com.eurowings.flight.service.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {FlightServiceImpl.class, FlightRepository.class})
@EnableAutoConfiguration

class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFlightByIdWhenIdExists() {
        Flight flight = new Flight();
        flight.setId("1");
        when(flightRepository.findById("1")).thenReturn(Optional.of(flight));
        Flight result = flightService.getFlightById("1");
        assertEquals(flight, result);
    }

    @Test
    void testGetFlightByIdWhenIdDoesNotExist() {
        when(flightRepository.findById("1")).thenReturn(Optional.empty());
        Flight result = flightService.getFlightById("1");
        assertNull(result);
    }

    @Test
    void testGetFlightByIdWhenIdIsNull() {
        when(flightRepository.findById(null)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> {
            flightService.getFlightById(null);
        });

    }
}