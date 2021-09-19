package com.cinema.ticket_reservation.movie_show.query;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie-shows")
@AllArgsConstructor
class MovieShowQueryController {

    private final MovieShowQueryRepository repository;

    @GetMapping("date/{date}")
    ResponseEntity<List<MovieShowQueryDto>> getByDate(@PathVariable("date") String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return ResponseEntity.ok(repository.findAllByDateOrderByMovieTitleAscTimeAsc(parsedDate));
    }

    @GetMapping("/{id}")
    ResponseEntity<MovieShowQueryDto> getById(@PathVariable("id") Long id) {
        Optional<MovieShowQueryDto> optShow = repository.findById(id);
        if (optShow.isPresent()) {
            return ResponseEntity.ok(optShow.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/movie/{id}")
    ResponseEntity<List<MovieShowQueryDto>> getByMovieId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(repository.findAllByMovieIdOrderByDateAscTimeAsc(id));
    }

}
