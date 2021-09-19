package com.cinema.ticket_reservation;

import com.cinema.ticket_reservation.movie.domain.MovieInitData;
import com.cinema.ticket_reservation.movie.query.MovieQueryDto;
import com.cinema.ticket_reservation.movie_show.domain.MovieShowInitData;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class TicketReservationApplication implements CommandLineRunner {

	private final MovieInitData movieInitData;
	private final MovieShowInitData movieShowInitData;

	public static void main(String[] args) {
		SpringApplication.run(TicketReservationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Set<MovieQueryDto> movieQueryDtos = movieInitData.initMovies();
		movieShowInitData.InitShows(movieQueryDtos);
	}
}
