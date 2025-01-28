package com.scaler.bookmyshowjan25.repositories;

import com.scaler.bookmyshowjan25.models.SeatType;
import com.scaler.bookmyshowjan25.models.Show;
import com.scaler.bookmyshowjan25.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    ShowSeatType findAllByShowAndSeatType(Show show, SeatType seatType);

    List<ShowSeatType> findAllByShow(Show show);
    //select * from show_seat_type where show = 100
}
