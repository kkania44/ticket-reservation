package com.cinema.ticket_reservation.movie_show.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

}
