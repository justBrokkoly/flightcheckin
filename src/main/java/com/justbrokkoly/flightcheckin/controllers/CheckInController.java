package com.justbrokkoly.flightcheckin.controllers;

import com.justbrokkoly.flightcheckin.integration.ReservationRestClient;
import com.justbrokkoly.flightcheckin.integration.dto.Reservation;
import com.justbrokkoly.flightcheckin.integration.dto.ResrvationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRestClient restClient;

    @GetMapping("/showStartCheckin")
    public String showStartCheckIn(){
        return "startCheckIn";
    }

    @PostMapping("/startCheckIn")
    public String StartCheckIn(@RequestParam("reservationId" ) Long reservationId, Model model){ //имя в jsp
        Reservation reservation = restClient.findReservation(reservationId);

        model.addAttribute("reservation", reservation);

        return "displayReservationDetails";
    }

    @PostMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
                                  @RequestParam("numberOfBags") int numberOfBags){

        ResrvationUpdateRequest resrvationUpdateRequest = new ResrvationUpdateRequest();
        resrvationUpdateRequest.setId(reservationId);
        resrvationUpdateRequest.setCheckedIn(true);
        resrvationUpdateRequest.setNumberOfBags(numberOfBags);
        restClient.updateReservation(resrvationUpdateRequest);

        return "checkInConfirmation";
    }
}
