package com.myhotel.reservations.business;

import com.myhotel.reservations.data.Hotel;
import com.myhotel.reservations.data.HotelRepository;
import com.myhotel.reservations.data.Reservation;
import com.myhotel.reservations.data.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class ReservationService {
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(HotelRepository hotelRepository, ReservationRepository reservationRepository) {
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
    }

    public String add(Reservation reservation) throws Exception{

            reservation.setRoomNumber(1);
            boolean isOutsidePlanningPeriod = isOutsidePlanningPeriod(reservation);
            if(isOutsidePlanningPeriod)
                throw new Exception("Value out of Range");

            this.reservationRepository.save(reservation);
          return this.hotelRepository.findById(1).get().getHotelName();
    }

    private boolean isOutsidePlanningPeriod (Reservation reservation)
    {
        if (reservation.getEndDay()<0 || reservation.getEndDay()>365)
            return true;
        else if (reservation.getStartDay()<0 || reservation.getStartDay()>365)
            return true;
        else
            return false;

    }


}