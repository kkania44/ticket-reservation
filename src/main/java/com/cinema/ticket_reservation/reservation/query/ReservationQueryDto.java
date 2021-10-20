package com.cinema.ticket_reservation.reservation.query;

import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;
import com.cinema.ticket_reservation.reservation.dto.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReservationQueryDto {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_show_id")
    private MovieShowQueryDto movieShow;
    private String seats;
    private String customerEmail;
    private LocalDateTime createdOn;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

}
