package com.scaler.bookmyshowjan25.repositories;

import com.scaler.bookmyshowjan25.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);
    // select * from show_seats where id IN (12, 13, 18, 17)


    @Override
    ShowSeat save(ShowSeat showSeat);
}
