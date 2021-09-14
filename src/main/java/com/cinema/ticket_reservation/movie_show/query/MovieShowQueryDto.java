package com.cinema.ticket_reservation.movie_show.query;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieShowQueryDto {

    private Long id;
    private MovieQueryDto movie;
    private LocalDate date;
    private LocalTime time;
    private int screeningRoom;
    private boolean isPremiere;

}
