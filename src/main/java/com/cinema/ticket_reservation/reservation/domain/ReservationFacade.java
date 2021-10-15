package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.reservation.dto.*;
import com.cinema.ticket_reservation.reservation.query.ReservationQueryDto;
import lombok.AllArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.cinema.ticket_reservation.reservation.dto.ReservationStatus.*;
import static java.util.Arrays.asList;

@AllArgsConstructor
public class ReservationFacade {

    private final ReservationRepository repository;

    public ReservationQueryDto createReservation(CreateReservationDto dto) {
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

    public ReservationQueryDto confirmReservation(ConfirmReservationDto dto) {
        Reservation reservation = repository.findById(dto.getReservationId())
                .orElseThrow(EntityNotFoundException::new);
        if (reservation.getStatus().equals(EXPIRED)) {
            throw new ReservationExpiredException("Your reservation expired. Please, choose your seats again.");
        }
        if (reservation.getStatus().equals(CONFIRMED) && reservation.getCustomerEmail().equals(dto.getEmail())) {
            return reservation.query();
        }
        if (reservation.getStatus().equals(STARTED)) {
            reservation.setStatus(CONFIRMED);
            reservation.setCustomerEmail(dto.getEmail());
            return repository.save(reservation).query();
        }
        throw new RuntimeException("Error occured. Reservation has not been confirmed.");
    }

}
