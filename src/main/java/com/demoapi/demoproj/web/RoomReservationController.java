package com.demoapi.demoproj.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoapi.demoproj.business.ReservationService;
import com.demoapi.demoproj.business.RoomReservation;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final ReservationService reservationService;

    public RoomReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    /**
     * @return
     */

    @RequestMapping(method=RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false) String dateString , Model model) {
        List<RoomReservation> roomReservations = reservationService
                .getRoomReservationsForDate(java.sql.Date.valueOf("2022-01-01"));
                model.addAttribute("roomReservations", roomReservations);
        return "roomres";

    }

}
