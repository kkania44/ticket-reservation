package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.reservation.dto.ReservationStatus;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

interface ReservationRepository {

    Set<Reservation> findAllByMovieShowIdAndStatusIn(Long movieShowId, Collection<ReservationStatus> statuses);

    Reservation save(Reservation reservation);

    Optional<Reservation> findById(Long id);

    Set<Reservation> findAllByStatusAndCreatedOnLessThan(ReservationStatus status, LocalDateTime dateTime);

}
