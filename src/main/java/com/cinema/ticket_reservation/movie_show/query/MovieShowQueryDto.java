package com.cinema.ticket_reservation.movie_show.query;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movie_show")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MovieShowQueryDto {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieQueryDto movie;
    private LocalDate date;
    private LocalTime time;
    private int screeningRoom;
    private boolean isPremiere;

}
