package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.*;
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

    @OneToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private Show show;

    private int amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL) // Numeric
    private BookingStatus bookingStatus;
}


/*
   1            1
Booking ----- User  => M:1
  M            1

   1             M
Booking ----- ShowSeat => 1:M
   1              1

   1            1
Booking ----- Show => M:1
   m            1

   1            M
Booking ----- Payment => 1:M
  1              1

 */