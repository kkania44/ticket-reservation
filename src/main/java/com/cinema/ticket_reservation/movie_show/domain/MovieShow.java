package com.cinema.ticket_reservation.movie_show.domain;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movie_show")
@NoArgsConstructor
@Getter
public class MovieShow {

    private Long id;
    private MovieQueryDto movie;
    private LocalDate date;
    private LocalTime time;
    private int screeningRoom;
    private boolean isPremiere;

    public MovieShow(MovieQueryDto movie, LocalDate date, LocalTime time, int screeningRoom, boolean isPremiere) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.screeningRoom = screeningRoom;
        this.isPremiere = isPremiere;
    }
}
