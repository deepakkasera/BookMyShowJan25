package com.scaler.bookmyshowjan25.controllers;

import com.scaler.bookmyshowjan25.dtos.CreateBookingRequestDto;
import com.scaler.bookmyshowjan25.dtos.CreateBookingResponseDto;
import com.scaler.bookmyshowjan25.dtos.ResponseStatus;
import com.scaler.bookmyshowjan25.models.Booking;
import com.scaler.bookmyshowjan25.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto) {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();
        try {
            Booking booking = bookingService.createBooking(
                    requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds()
            );

            responseDto.setBooking(booking);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
