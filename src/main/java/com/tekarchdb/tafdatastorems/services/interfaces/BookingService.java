package com.tekarchdb.tafdatastorems.services.interfaces;

import com.tekarchdb.tafdatastorems.models.Bookings;
import com.tekarchdb.tafdatastorems.models.BookingsDTO;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Bookings bookFlight(Bookings booking);

    Optional<Bookings> getBookedDetailsById(Long bookingId);

    List<Bookings> getBookedDetailsByUserId(Long userId);

    void updateBookingDetails(Long id, Bookings bookedDetails);
}
