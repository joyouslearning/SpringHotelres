package com.demoapi.demoproj.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Date;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
    
    	List<Reservation> findByResDate(Date resDate);
        List<Reservation> findByGuestId(long guestId);
        List<Reservation> findByReservationId(long reservationId);

}
