package com.cinema.ticket_reservation.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface MovieRepository extends JpaRepository<Movie, Long> {

}
