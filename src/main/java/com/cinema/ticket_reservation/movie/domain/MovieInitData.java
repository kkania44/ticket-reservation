package com.cinema.ticket_reservation.movie.domain;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MovieInitData {

    private final MovieRepository repository;

    public Set<MovieQueryDto> initMovies() {
        Movie movie1 = new Movie("Title 1", "Director 1", 2020, "Actor 1, Actress 1",
                LocalDate.now().minusDays(15), "Movie description 123 123", "Fantasy");
        Movie movie2 = new Movie("Title 12", "Director 4", 2021, "Actress 1, Actress 2",
                LocalDate.now().minusDays(5), "Movie description 123 123", "Action");
        Movie movie3 = new Movie("Title 3", "Director 5", 2020, "Actor 4, Actor 6",
                LocalDate.now(), "Movie description 253 124", "Drama");
        Movie movie4 = new Movie("Title 4", "Director 7", 2020, "Actor 3, Actress 5",
                LocalDate.now().plusDays(5), "Movie description 5324 134", "Comedy");
        HashSet<Movie> movies = new HashSet<>(Arrays.asList(movie1, movie2, movie3, movie4));

        return repository.saveAll(movies).stream().map(Movie::query).collect(Collectors.toSet());
    }
}
