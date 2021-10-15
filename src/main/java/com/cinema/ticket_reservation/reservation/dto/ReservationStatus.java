package com.cinema.ticket_reservation.reservation.dto;

public enum ReservationStatus {

    STARTED("STARTED"),
    CONFIRMED("CONFIRMED"),
    EXPIRED("EXPIRED"),
    CANCELLED("CANCELLED");

    private String value;

    ReservationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
