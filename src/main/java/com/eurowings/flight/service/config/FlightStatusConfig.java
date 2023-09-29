package com.eurowings.flight.service.config;

import com.eurowings.flight.service.service.FlightService;
import com.eurowings.flight.service.service.FlightServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlightStatusConfig {

    @Bean
    public FlightService flightService() {
        return new FlightServiceImpl();
    }
}
