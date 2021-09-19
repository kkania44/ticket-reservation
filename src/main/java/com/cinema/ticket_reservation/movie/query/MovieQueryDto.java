package com.cinema.ticket_reservation.movie.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "movie")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieQueryDto {

    @Id
    private Long id;
    private String title;
    private String director;
    private Integer productionYear;
    private String mainCast;
    private LocalDate premiere;
    private String description;
    private String genre;

}
