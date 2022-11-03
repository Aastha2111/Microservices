package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entites.Booking;

public interface BookingService {

    Booking addBooking(Booking booking);

    List<Booking> getAllBookings();

}
