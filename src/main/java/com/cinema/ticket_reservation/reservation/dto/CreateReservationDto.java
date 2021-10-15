package com.cinema.ticket_reservation.reservation.dto;

import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateReservationDto {

    private MovieShowQueryDto movieShow;
    private String seats;

}
