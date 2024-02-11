package com.bus.booking.busBooking.repositories;

import com.bus.booking.busBooking.entities.Booking;
import com.bus.booking.busBooking.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    int countByBusAndDate(Bus bus, Date date);

    boolean existsByBusId(Long id);
}
