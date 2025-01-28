package com.scaler.bookmyshowjan25.controllers;

import com.scaler.bookmyshowjan25.dtos.CreateBookingRequestDto;
import com.scaler.bookmyshowjan25.dtos.CreateBookingResponseDto;
import com.scaler.bookmyshowjan25.models.Booking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @PostMapping("/book")
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto) {
        return null;
    }
}
