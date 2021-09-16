package com.cinema.ticket_reservation.movie.query;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

interface MovieQueryRepository {

    Optional<MovieQueryDto> findById(Long id);

    Set<MovieQueryDto> findAllByTitleContainingIgnoreCase(String title);

    Set<MovieQueryDto> findAllByGenre(String genre);

    Page<MovieQueryDto> findByPremiereGreaterThan(LocalDate date, Pageable pageable);

}
