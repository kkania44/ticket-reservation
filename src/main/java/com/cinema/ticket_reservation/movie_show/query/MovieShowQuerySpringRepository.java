package com.cinema.ticket_reservation.movie_show.query;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

interface MovieShowQuerySpringRepository extends MovieShowQueryRepository, Repository<MovieShowQueryDto, Long> {

    @Override
    List<MovieShowQueryDto> findAllByDateOrderByMovieTitleAscTimeAsc(LocalDate date);

    @Override
    Optional<MovieShowQueryDto> findById(Long id);

    @Override
    List<MovieShowQueryDto> findAllByMovieIdOrderByDateAscTimeAsc(Long id);
}
