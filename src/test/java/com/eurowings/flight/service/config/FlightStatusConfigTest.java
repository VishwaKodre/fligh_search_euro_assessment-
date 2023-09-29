package com.eurowings.flight.service.config;

import com.eurowings.flight.service.service.FlightService;
import com.eurowings.flight.service.service.FlightServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {FlightStatusConfig.class, FlightServiceImpl.class})
@EnableAutoConfiguration
class FlightStatusConfigTest {

    @Test
    void testFlightServiceWhenCalledThenReturnFlightServiceImpl() {
        // Arrange
        FlightStatusConfig flightStatusConfig = new FlightStatusConfig();

        // Act
        FlightService flightService = flightStatusConfig.flightService();

        // Assert
        assertTrue(flightService instanceof FlightServiceImpl);
    }
}