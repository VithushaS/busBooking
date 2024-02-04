package com.bus.booking.busBooking.service;

import com.bus.booking.busBooking.dto.BusRequest;
import com.bus.booking.busBooking.dto.BusRespose;

import java.util.List;

public interface BusService {
    void saveBus(BusRequest busRequest);
   boolean checkExistsBusNo(Long busNo);
    List<BusRespose> getAllBuses();
   boolean existsById(Long id);
}
