package com.cinema.ticket_reservation.movie.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

interface MovieRepository {

    Movie save(Movie movie);

    Optional<Movie> findById(Long id);

    Set<Movie> findByGenre(String genre);

    List<Movie> findWithPremiereDateAfter(LocalDate date);

    void deleteById(Long id);

}
