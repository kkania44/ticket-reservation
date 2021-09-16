package com.cinema.ticket_reservation.movie.query;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
class MovieQueryController {

    private final MovieQueryRepository movieRepository;

    @GetMapping("/{id}")
    ResponseEntity<MovieQueryDto> getById(@PathVariable("id") Long id) {
        Optional<MovieQueryDto> movieOpt = movieRepository.findById(id);
        if (movieOpt.isPresent()) {
            return ResponseEntity.ok(movieOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/title/{title}")
    ResponseEntity<Set<MovieQueryDto>> getWithTitleContaining(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieRepository.findAllByTitleContainingIgnoreCase(title));
    }

    @GetMapping("/genre/{genre}")
    ResponseEntity<Set<MovieQueryDto>> getByGenre(@PathVariable("genre") String genre) {
        return ResponseEntity.ok(movieRepository.findAllByGenre(genre));
    }

    @GetMapping("/premiere/{date}/page/{page}/size/{size}")
    ResponseEntity<Page<MovieQueryDto>> getPageWithPremiereAfter(
            @PathVariable("date") String date,
            @PathVariable("page") int page,
            @PathVariable("size") int size) {
        LocalDate parsedDate = LocalDate.parse(date);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("premiere"));
        return ResponseEntity.ok(movieRepository.findByPremiereGreaterThan(parsedDate,  pageRequest));
    }

}
