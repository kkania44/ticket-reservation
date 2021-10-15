package com.cinema.ticket_reservation.reservation.query;

import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReservationQueryDto {

    @Id
    private Long id;
    private MovieShowQueryDto movieShow;
    private String seats;
    private String customerEmail;
    private LocalDateTime createdOn;

}
