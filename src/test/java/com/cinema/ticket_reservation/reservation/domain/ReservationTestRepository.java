package com.cinema.ticket_reservation.reservation.domain;

import com.cinema.ticket_reservation.reservation.dto.ReservationStatus;
import lombok.AllArgsConstructor;

import java.util.*;

class ReservationTestRepository implements ReservationRepository {

    private Map<Long, Reservation> reservations = new HashMap<>();
    private Long id = 1L;

    @Override
    public Set<Reservation> findAllByMovieShowIdAndStatusIn(Long movieShowId, Collection<ReservationStatus> statuses) {
        Set<Reservation> result = new HashSet<>();
        for (Map.Entry<Long, Reservation> res: reservations.entrySet()) {
            Reservation value = res.getValue();
            if (value.getMovieShow().getId().equals(movieShowId) && statuses.contains(value.getStatus())) {
                result.add(value);
            }
        }
        return result;
    }

    @Override
    public Reservation save(Reservation reservation) {
        if (reservation != null) {
            reservation.setId(id);
            reservations.put(id, reservation);
            id++;
        }
        return reservation;
    }

    Reservation getById(Long id) {
        return reservations.get(id);
    }

}
