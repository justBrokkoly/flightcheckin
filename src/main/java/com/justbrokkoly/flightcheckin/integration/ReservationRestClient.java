package com.justbrokkoly.flightcheckin.integration;

import com.justbrokkoly.flightcheckin.integration.dto.Reservation;
import com.justbrokkoly.flightcheckin.integration.dto.ResrvationUpdateRequest;

public interface ReservationRestClient {

    Reservation findReservation(Long id);
    Reservation updateReservation(ResrvationUpdateRequest request);
}
