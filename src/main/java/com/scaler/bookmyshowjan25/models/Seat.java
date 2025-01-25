package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {
    private int rowValue;
    private int colValue;
    private int seatNumber;

    @ManyToOne
    private SeatType seatType;
}
