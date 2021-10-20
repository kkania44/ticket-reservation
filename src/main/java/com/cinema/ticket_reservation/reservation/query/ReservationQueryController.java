package com.cinema.ticket_reservation.reservation.query;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
class ReservationQueryController {

    private final ReservationQueryRepository repository;

    @GetMapping("/movie-show/{id}/occupied-seats")
    ResponseEntity<?> getOccupiedSeats(@PathVariable("id") Long id) {
        ArrayList<String> seats = new ArrayList<>();
        List<String> occupiedSeats = repository.findAllByMovieShowId(id).stream()
                .map(ReservationQueryDto::getSeats)
                .collect(Collectors.toList());
        for (String s: occupiedSeats) {
            seats.addAll(Arrays.asList(s.split(",")));
        }
        return ResponseEntity.ok(seats);
    }

}
