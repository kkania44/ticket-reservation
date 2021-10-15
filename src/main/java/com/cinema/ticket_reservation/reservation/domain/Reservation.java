package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;
import com.cinema.ticket_reservation.reservation.dto.ReservationStatus;
import com.cinema.ticket_reservation.reservation.query.ReservationQueryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Getter
class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_show_id")
    private MovieShowQueryDto movieShow;
    private String seats;
    @Setter
    private String customerEmail;
    private LocalDateTime createdOn;
    private ReservationStatus status;

    Reservation(MovieShowQueryDto movieShow, String seats) {
        this.movieShow = movieShow;
        this.seats = seats;
        this.createdOn = LocalDateTime.now();
        this.status = ReservationStatus.STARTED;
    }

    ReservationQueryDto query() {
        return new ReservationQueryDto(id, movieShow,seats,customerEmail,createdOn);
    }
}
