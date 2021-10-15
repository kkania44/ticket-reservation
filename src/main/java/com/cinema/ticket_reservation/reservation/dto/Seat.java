package com.cinema.ticket_reservation.reservation.dto;

import java.util.Objects;

public class Seat {

    private String row;
    private int number;

    public int getNumber() {
        return number;
    }

    public String getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return number == seat.number &&
                Objects.equals(row, seat.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, number);
    }
}
