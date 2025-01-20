package com.tekarchdb.tafdatastorems.services;

import com.tekarchdb.tafdatastorems.models.Bookings;
import com.tekarchdb.tafdatastorems.models.BookingsDTO;
import com.tekarchdb.tafdatastorems.models.Flights;
import com.tekarchdb.tafdatastorems.repositories.BookingRepository;
import com.tekarchdb.tafdatastorems.repositories.FlightRepository;
import com.tekarchdb.tafdatastorems.services.interfaces.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;


    @Override
    public Bookings bookFlight(Bookings booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Bookings> getBookedDetailsById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public List<Bookings> getBookedDetailsByUserId(Long userId) {
        return bookingRepository.findByUsersId(userId);
    }

    @Override
    public void updateBookingDetails(Long id, Bookings bookedDetails) {
        bookingRepository.save(bookedDetails);
    }
}
