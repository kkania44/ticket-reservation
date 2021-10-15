package com.cinema.ticket_reservation.reservation.query;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
class ReservationQueryController {

    private final ReservationQueryRepository repository;

    @GetMapping("/movie-show/{id}/occupied-seats")
    ResponseEntity<?> getOccupiedSeats(@PathVariable("id") Long id) {
        ArrayList<String> seats = new ArrayList<>();
        repository.findAllByMovieShowId(id).forEach(r -> seats.add(r.getSeats()));
        return ResponseEntity.ok(seats);
    }

}
