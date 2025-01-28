package com.scaler.bookmyshowjan25.services;

import com.scaler.bookmyshowjan25.models.*;
import com.scaler.bookmyshowjan25.repositories.BookingRepository;
import com.scaler.bookmyshowjan25.repositories.ShowRepository;
import com.scaler.bookmyshowjan25.repositories.ShowSeatRepository;
import com.scaler.bookmyshowjan25.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private PriceCalculationService priceCalculationService;

    public BookingService(UserRepository userRepository, ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          BookingRepository bookingRepository,
                          PriceCalculationService priceCalculationService) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculationService = priceCalculationService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
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

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            //throw an exception
            throw new RuntimeException("UserId: " + userId + " is invalid.");
        }

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()) {
            //throw an exception
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Show seat not available.");
            }
        }

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(showSeats);
        booking.setShow(show);
        booking.setAmount(priceCalculationService.calculatePrice(show, showSeats));

        return bookingRepository.save(booking);
    }
}
