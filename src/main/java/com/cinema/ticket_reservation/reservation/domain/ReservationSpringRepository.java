package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.reservation.dto.ReservationStatus;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

interface ReservationSpringRepository extends ReservationRepository, Repository<Reservation, Long> {

    @Override
    Set<Reservation> findAllByMovieShowIdAndStatusIn(Long movieShowId, Collection<ReservationStatus> statuses);

    @Override
    Reservation save(Reservation reservation);

    @Override
    Optional<Reservation> findById(Long id);


}
