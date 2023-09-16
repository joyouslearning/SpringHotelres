package com.demoapi.demoproj.webservice;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.demoapi.demoproj.business.ReservationService;
import com.demoapi.demoproj.business.RoomReservation;
import com.demoapi.demoproj.data.Guest;

@RestController
@RequestMapping("/api/hotelres")
public class WebServicecontroller {
    
    private final ReservationService reservationService;

    public WebServicecontroller(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/resv" , method =RequestMethod.GET) 
    public List<RoomReservation> getReservations(@RequestParam(value="date" , required= false) String dateString)
    {
        if (dateString != null)
            return reservationService.getRoomReservationsForDate(java.sql.Date.valueOf(dateString));

        else
            return reservationService.getRoomReservationsForDate(java.sql.Date.valueOf("2022-01-01"));
    }

    @GetMapping("/guests")
    public List<Guest> getGuestList()
    {
        return this.reservationService.getHotelGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuests(@RequestBody Guest guest)
    {
       this.reservationService.addGuest(guest);
    }

}
