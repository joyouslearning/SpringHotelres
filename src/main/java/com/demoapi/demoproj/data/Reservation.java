package com.demoapi.demoproj.data;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RESERVATION_ID")
    private long reservationId; 
    @Column(name="ROOM_ID")
    private long roomId;
    @Column(name="GUEST_ID")
    private long guestId;
    @Column(name="RES_DATE")
    private Date resDate;

    @Override
    public String toString() {
        return "{" +
            " reservationId='" + getReservationId() + "'" +
            ", roomId='" + getRoomId() + "'" +
            ", guestId='" + getGuestId() + "'" +
            ", resDate='" + getResDate() + "'" +
            "}";
    }

    public long getReservationId() {
        return this.reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return this.guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getResDate() {
        return this.resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }
             
  
}
