package com.cinema.ticket_reservation.reservation.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ReservationConfiguration {

    @Bean
    ReservationFacade reservationFacade(ReservationSpringRepository repository) {
        return new ReservationFacade(repository);
    }
}
