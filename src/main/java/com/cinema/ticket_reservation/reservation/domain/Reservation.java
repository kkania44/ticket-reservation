package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;

public class Reservation {

    private Long id;
    private MovieShowQueryDto movieShow;
    private String seats;
    private String customerEmail;

}
