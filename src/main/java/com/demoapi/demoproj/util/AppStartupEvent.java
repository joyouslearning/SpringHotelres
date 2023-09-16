package com.demoapi.demoproj.util;

import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.demoapi.demoproj.business.ReservationService;
import com.demoapi.demoproj.business.RoomReservation;
import com.demoapi.demoproj.data.Reservation;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private ReservationService reservationService;

    public AppStartupEvent(ReservationService reservationService) {
        this.reservationService = reservationService;
     }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<RoomReservation> roomReservation = reservationService
        .getRoomReservationsForDate(java.sql.Date.valueOf("2022-01-01"));
        System.out.println("**************************************");
        roomReservation.forEach(System.out::println);
    }

}
