package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private int price;
}

/*

    1               1
ShowSeatType ---- Show => M:1
    M              1


1G
1S
1P
2G
2S
2P

 */