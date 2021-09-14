package com.cinema.ticket_reservation.movie.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class MovieRepositoryImpl implements MovieRepository {

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Set<Movie> findByGenre(String genre) {
        return null;
    }

    @Override
    public List<Movie> findWithPremiereDateAfter(LocalDate date) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
