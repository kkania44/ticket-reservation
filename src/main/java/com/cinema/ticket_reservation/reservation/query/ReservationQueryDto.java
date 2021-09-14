package com.cinema.ticket_reservation.reservation.query;

import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;

public class ReservationQueryDto {

    private Long id;
    private MovieShowQueryDto movieShow;
    private String seats;
    private String customerEmail;

}
