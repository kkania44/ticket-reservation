package com.cinema.ticket_reservation.reservation.dto;

public class SeatOccupiedException extends RuntimeException {

    public SeatOccupiedException(String message) {
        super(message);
    }
}
