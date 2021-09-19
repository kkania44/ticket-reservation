package com.cinema.ticket_reservation.movie_show.domain;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movie_show")
@NoArgsConstructor
@Getter
class MovieShow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieQueryDto movie;
    private LocalDate date;
    private LocalTime time;
    private int screeningRoom;
    private boolean isPremiere;

    MovieShow(MovieQueryDto movie, LocalDate date, LocalTime time, int screeningRoom, boolean isPremiere) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.screeningRoom = screeningRoom;
        this.isPremiere = isPremiere;
    }
}
