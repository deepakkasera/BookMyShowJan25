package com.scaler.bookmyshowjan25.repositories;

import com.scaler.bookmyshowjan25.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking booking);
}
