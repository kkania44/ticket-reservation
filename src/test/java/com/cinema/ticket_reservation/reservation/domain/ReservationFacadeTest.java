package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import com.cinema.ticket_reservation.movie_show.query.MovieShowQueryDto;
import com.cinema.ticket_reservation.reservation.dto.CreateReservationDto;
import com.cinema.ticket_reservation.reservation.dto.ReservationStatus;
import com.cinema.ticket_reservation.reservation.dto.SeatOccupiedException;
import com.cinema.ticket_reservation.reservation.query.ReservationQueryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationFacadeTest {

    private ReservationFacade facade;
    private ReservationTestRepository testRepo;

    @BeforeEach
    void setup() {
        testRepo = new ReservationTestRepository();
        facade = new ReservationFacade(testRepo);
    }

    @Test
    void shouldCreateReservation() {
        MovieShowQueryDto movieShowQueryDto = new MovieShowQueryDto(
                1L, new MovieQueryDto(), LocalDate.now(), LocalTime.of(12, 0), 1, false);
        Reservation reservation1 = new Reservation(movieShowQueryDto, "D1,D2,D3");
        Reservation reservation2 = new Reservation(movieShowQueryDto, "E5,E6,E7,E8");
        Reservation reservation3 = new Reservation(movieShowQueryDto, "F12,F13");
        testRepo.save(reservation1);
        testRepo.save(reservation2);
        testRepo.save(reservation3);
        CreateReservationDto createReservationDto = new CreateReservationDto(movieShowQueryDto, "G1,G2");
        facade.createReservation(createReservationDto);
        Reservation actualReservation = testRepo.getById(4L);
        assertNotNull(actualReservation);
        assertEquals(4L, actualReservation.getId());
        assertEquals(ReservationStatus.STARTED, actualReservation.getStatus());
        assertEquals("G1,G2", actualReservation.getSeats());

    }

    @Test
    void shouldNotCreateReservationIfSeatIsOccupied() {
        MovieShowQueryDto movieShowQueryDto = new MovieShowQueryDto(
                1L, new MovieQueryDto(), LocalDate.now(), LocalTime.of(12, 0), 1, false);
        Reservation reservation1 = new Reservation(movieShowQueryDto, "D1,D2,D3");
        Reservation reservation2 = new Reservation(movieShowQueryDto, "E5,E6,E7,E8");
        testRepo.save(reservation1);
        testRepo.save(reservation2);
        CreateReservationDto createReservationDto = new CreateReservationDto(movieShowQueryDto, "E4,E5");
        Exception ex = assertThrows(SeatOccupiedException.class,
                () -> facade.createReservation(createReservationDto));
        Reservation actualReservation = testRepo.getById(3L);
        assertNull(actualReservation);
        assertTrue(ex.getMessage().contains("Seat E5 is already occupied"));
    }

}