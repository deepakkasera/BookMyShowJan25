package com.scaler.bookmyshowjan25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

/*

   1                1
ShowSeat --------- Show => M:1
   M                1

   1                 1
ShowSeat --------- Seat => M:1
  M                  1

1A1
1A2
1A3
2A1
2A2
2B1


X Y

XY ---- X => M:1
XY ---- Y => M:1

 */
