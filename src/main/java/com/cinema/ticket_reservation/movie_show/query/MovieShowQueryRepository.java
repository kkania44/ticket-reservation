package com.cinema.ticket_reservation.movie_show.query;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

interface MovieShowQueryRepository {

    List<MovieShowQueryDto> findAllByDateOrderByMovieTitleAscTimeAsc(LocalDate date);

    Optional<MovieShowQueryDto> findById(Long id);

    List<MovieShowQueryDto> findAllByMovieIdOrderByDateAscTimeAsc(Long id);

}
