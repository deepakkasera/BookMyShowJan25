package com.scaler.bookmyshowjan25.dtos;

import com.scaler.bookmyshowjan25.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}
