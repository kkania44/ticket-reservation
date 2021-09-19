package com.cinema.ticket_reservation.movie.domain;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movie")
@Getter
@NoArgsConstructor
class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String director;
    private Integer productionYear;
    private String mainCast;
    private LocalDate premiere;
    private String description;
    private String genre;

    public Movie(String title, String director, Integer productionYear, String mainCast, LocalDate premiere, String description, String genre) {
        this.title = title;
        this.director = director;
        this.productionYear = productionYear;
        this.mainCast = mainCast;
        this.premiere = premiere;
        this.description = description;
        this.genre = genre;
    }

    MovieQueryDto query() {
        return new MovieQueryDto(id,
                title, director, productionYear, mainCast, premiere, description, genre);
    }

}
