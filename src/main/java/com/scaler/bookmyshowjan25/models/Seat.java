package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {
    private int rowNumber;
    private int colNumber;
    private int seatNumber;
    private SeatType seatType;
}
