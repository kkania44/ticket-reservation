package com.cinema.ticket_reservation.movie_show.domain;

import org.springframework.data.repository.Repository;

import java.util.Set;

interface MovieShowRepository extends Repository<MovieShow, Long> {

    Set<MovieShow> saveAll(Set<MovieShow> shows);

}
