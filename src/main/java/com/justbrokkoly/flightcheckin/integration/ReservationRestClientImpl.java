package com.justbrokkoly.flightcheckin.integration;

import com.justbrokkoly.flightcheckin.integration.dto.Reservation;
import com.justbrokkoly.flightcheckin.integration.dto.ResrvationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String RESERVATION_REST_URL="http://localhost:8080/reservations/";

    @Override
    public Reservation findReservation(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id,Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ResrvationUpdateRequest request) {

        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation=restTemplate.postForObject(RESERVATION_REST_URL,request,Reservation.class);
        return reservation;
    }
}
