package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entites.Booking;
import org.ncu.hirewheels.entites.LoginUser;
import org.ncu.hirewheels.entites.User;
import org.ncu.hirewheels.service.BookingService;
import org.ncu.hirewheels.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

  private BookingService bookingService;

  public BookingController(BookingService bookingService) {
    super();
    this.bookingService = bookingService;
  }

  @PostMapping()
  public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
    return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.OK);
  }

  @GetMapping
  public List<Booking> getAlLBooking() {
    return bookingService.getAllBookings();
  }

}
