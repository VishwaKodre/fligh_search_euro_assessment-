package com.eurowings.flight.service.model;

public enum FlightStatus {
    ON_TIME("On Time"),
    DELAYED("Delayed"),
    CANCELED("Canceled"),
    DIVERTED("Diverted"),
    ARRIVED("Arrived"),
    DEPARTED("Departed"),
    BOARDING("Boarding"),
    CHECK_IN("Check-in"),
    UNKNOWN("Unknown");

    private final String displayName;

    FlightStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
