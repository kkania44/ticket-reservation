package com.cinema.ticket_reservation.reservation.query;

import org.springframework.data.repository.Repository;

import java.util.Set;

interface ReservationQueryRepository extends Repository<ReservationQueryDto, Long> {

    Set<ReservationQueryDto> findAllByMovieShowId(Long id);

}
