package com.cinema.ticket_reservation.movie.domain;

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

}
