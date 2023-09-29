package com.eurowings.flight.service.service;

import com.eurowings.flight.service.model.Flight;

import java.util.List;

public interface FlightService {
    Flight getFlightById(String id);

    List<Flight> getAllFlights();
}
