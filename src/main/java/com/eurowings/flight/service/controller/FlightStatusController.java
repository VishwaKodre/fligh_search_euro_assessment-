package com.eurowings.flight.service.controller;

import com.eurowings.flight.service.model.Flight;
import com.eurowings.flight.service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/{version}/flights")
public class FlightStatusController {
    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> getFlightById(@PathVariable String id, @PathVariable final String version) {
        Flight flight = flightService.getFlightById(id);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> getAllFlights(@PathVariable final String version) {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }
}
