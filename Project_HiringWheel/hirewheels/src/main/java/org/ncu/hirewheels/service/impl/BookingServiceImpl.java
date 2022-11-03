package org.ncu.hirewheels.service.impl;

import java.util.List;

import org.ncu.hirewheels.entites.Booking;
import org.ncu.hirewheels.repository.BookingRespository;
import org.ncu.hirewheels.service.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRespository bookingRespository;

    public BookingServiceImpl(BookingRespository bookingRespository) {
        this.bookingRespository = bookingRespository;
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRespository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRespository.findAll();
    }

}
