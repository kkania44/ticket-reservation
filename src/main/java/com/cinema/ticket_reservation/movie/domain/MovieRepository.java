package com.cinema.ticket_reservation.movie.domain;

import org.springframework.data.repository.Repository;

import java.util.Set;

interface MovieRepository extends Repository<Movie, Long> {

    Set<Movie> saveAll(Set<Movie> movies);

}
