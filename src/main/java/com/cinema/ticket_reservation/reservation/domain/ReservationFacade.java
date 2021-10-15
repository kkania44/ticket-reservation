package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.reservation.dto.CreateReservationDto;
import com.cinema.ticket_reservation.reservation.dto.SeatOccupiedException;
import com.cinema.ticket_reservation.reservation.query.ReservationQueryDto;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.cinema.ticket_reservation.reservation.dto.ReservationStatus.*;
import static java.util.Arrays.asList;

@AllArgsConstructor
class ReservationFacade {

    private final ReservationRepository repository;

    ReservationQueryDto createReservation(CreateReservationDto dto) {
        Reservation reservation = new Reservation(dto.getMovieShow(), dto.getSeats());
        String[] seatsToReserve = reservation.getSeats().split(",");
        Set<Reservation> reservationsStartedOrConfirmed =
                repository.findAllByMovieShowIdAndStatusIn(dto.getMovieShow().getId(), asList(STARTED, CONFIRMED));
        List<String> occupiedSeats = new ArrayList<>();
        for (Reservation res  : reservationsStartedOrConfirmed) {
            occupiedSeats.addAll(Arrays.asList(res.getSeats().split(",")));
        }
        for (String seat: seatsToReserve) {
            if (occupiedSeats.contains(seat)) {
                throw new SeatOccupiedException(String.format("Seat %s is already occupied.", seat));
            }
        }
        return repository.save(reservation).query();
    }

}
