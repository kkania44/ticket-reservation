package com.cinema.ticket_reservation.movie.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

interface MovieQuerySpringRepository extends MovieQueryRepository, Repository<MovieQueryDto, Long> {

    @Override
    Optional<MovieQueryDto> findById(Long id);

    @Override
    Set<MovieQueryDto> findAllByTitleContainingIgnoreCase(String title);

    @Override
    Set<MovieQueryDto> findAllByGenre(String genre);

    @Override
    Page<MovieQueryDto> findByPremiereGreaterThan(LocalDate date, Pageable pageable);
}
