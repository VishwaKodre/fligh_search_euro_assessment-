package com.eurowings.flight.service.service;

import com.eurowings.flight.service.model.Flight;
import com.eurowings.flight.service.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private static final String ID_MUST_NOT_BE_NULL = "id must not be null";
    private FlightRepository flightRepository;

    @Override
    public Flight getFlightById(String id) {
        Assert.notNull(id, ID_MUST_NOT_BE_NULL);
        final Optional<Flight> flightResult = flightRepository.findById(id);
        return flightResult.orElse(null);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
