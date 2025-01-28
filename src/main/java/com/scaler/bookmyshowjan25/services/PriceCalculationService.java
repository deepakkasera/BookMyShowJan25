package com.scaler.bookmyshowjan25.services;

import com.scaler.bookmyshowjan25.models.Show;
import com.scaler.bookmyshowjan25.models.ShowSeat;
import com.scaler.bookmyshowjan25.models.ShowSeatType;
import com.scaler.bookmyshowjan25.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(Show show, List<ShowSeat> showSeats) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        int price = 0;

        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    price += showSeatType.getPrice();
                }
            }
        }

        return price;
    }
}


/*

ShowSeats =>  S1A1, S1B2

ShowSeatTypes => S1 Gold 300 | S1 Silver 200 | S1 Platinum 500
 */