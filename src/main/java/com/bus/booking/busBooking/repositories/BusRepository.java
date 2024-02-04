package com.bus.booking.busBooking.repositories;

import com.bus.booking.busBooking.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {

    boolean existsByBusNo(Long busNo);
}
