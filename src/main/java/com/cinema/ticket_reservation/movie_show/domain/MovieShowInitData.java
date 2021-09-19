package com.cinema.ticket_reservation.movie_show.domain;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class MovieShowInitData {

    private final MovieShowRepository repository;

    public void InitShows(Set<MovieQueryDto> movies) {
        HashSet<MovieShow> shows = new HashSet<>();

        for (MovieQueryDto movie : movies) {
            if (movie.getPremiere().isAfter(LocalDate.now())) {
                shows.add(new MovieShow(movie, movie.getPremiere(), LocalTime.of(14, 30), 4, true));
            } else {
                shows.add(new MovieShow(movie, LocalDate.now(), LocalTime.of(13, 30), 1, movie.getPremiere().isEqual(LocalDate.now())));
                shows.add(new MovieShow(movie, LocalDate.now(), LocalTime.of(17, 30), 1, movie.getPremiere().isEqual(LocalDate.now())));
                shows.add(new MovieShow(movie, LocalDate.now().plusDays(1), LocalTime.of(13, 30), 2, false));
                shows.add(new MovieShow(movie, LocalDate.now().plusDays(1), LocalTime.of(17, 30), 2, false));
            }
        }

        repository.saveAll(shows);
    }
}
