package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entites.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRespository extends JpaRepository<Booking, Long> {

}
