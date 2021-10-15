package com.cinema.ticket_reservation.reservation.dto;

public class ReservationExpiredException extends RuntimeException {

    public ReservationExpiredException(String message) {
        super(message);
    }
}
