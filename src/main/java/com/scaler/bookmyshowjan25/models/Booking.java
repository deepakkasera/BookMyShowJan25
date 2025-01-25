package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Ticket
@Entity
@Getter
@Setter
public class Booking extends BaseModel {
    @ManyToOne
    private User user;
    private List<ShowSeat> showSeats;
    private Show show;
    private int amount;
    private List<Payment> payments;
    private BookingStatus bookingStatus;
}


/*
   1            1
Booking ----- User  => M:1
  M            1

 */