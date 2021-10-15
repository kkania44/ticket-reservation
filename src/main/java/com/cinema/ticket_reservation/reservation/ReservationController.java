package com.cinema.ticket_reservation.reservation;

import com.cinema.ticket_reservation.reservation.domain.ReservationFacade;
import com.cinema.ticket_reservation.reservation.dto.ConfirmReservationDto;
import com.cinema.ticket_reservation.reservation.dto.CreateReservationDto;
import com.cinema.ticket_reservation.reservation.query.ReservationQueryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
class ReservationController {

    private final ReservationFacade reservationFacade;

    @PostMapping
    ResponseEntity<ReservationQueryDto> createReservation(@RequestBody CreateReservationDto dto) {
        ReservationQueryDto reservation = reservationFacade.createReservation(dto);
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("/{id}/confirm")
    ResponseEntity<?> confirmReservation(@RequestBody ConfirmReservationDto dto) {
        ReservationQueryDto reservation = reservationFacade.confirmReservation(dto);
        return ResponseEntity.ok(reservation);
    }

}
