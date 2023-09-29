package com.eurowings.flight.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Flight {
    @Id
    private String id;
    private String flightNumber;
    private String departureAirportCode;
    private String departureAirportName;
    private LocalDateTime departureTime;
    private String arrivalAirportCode;
    private String arrivalAirportName;
    private LocalDateTime arrivalTime;
    private FlightStatus status;
    private List<FlightRoute> flightRoute;
}
