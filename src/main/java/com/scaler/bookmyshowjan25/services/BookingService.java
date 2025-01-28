package com.scaler.bookmyshowjan25.services;

import com.scaler.bookmyshowjan25.models.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    public Booking createBooking(Long userId, Long showId, List<Long> showSeatIds) {
        /*
        1. Get the user from the DB with the given userId.
        2. Get the show from the DB with the given showId.
        3. Get the showSeats from the DB with the given showSeatIds.
        4. Check if all the seats are available or not, if not throw an exception.
        5. If all the seats are available, take a lock.
        6. Change the seat status to be BLOCKED, and release the lock.
        7. Check once again if the seats are still available.
        8. If yes, create a booking object with all the details and status as PENDING.
        9. Move to the payment page.
         */





        return null;
    }
}
