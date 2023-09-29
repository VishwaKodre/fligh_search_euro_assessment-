package com.eurowings.flight.service.repository;

import com.eurowings.flight.service.model.Flight;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CouchbaseRepository<Flight, String> {
}
