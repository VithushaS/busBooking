package com.bus.booking.busBooking.service;

import com.bus.booking.busBooking.dto.BookingRequest;
import com.bus.booking.busBooking.dto.BookingResponse;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingRequest bookingRequest);

    boolean existsById(Long id);

    void deleteBooking(Long id);

    List<BookingResponse> getAllBookings();

    boolean existsByBusId(Long id);
}
