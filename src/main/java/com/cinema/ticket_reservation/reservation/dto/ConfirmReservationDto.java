package com.cinema.ticket_reservation.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ConfirmReservationDto {

    private Long reservationId;
    private String email;
}
