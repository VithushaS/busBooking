package com.bus.booking.busBooking.service;

import com.bus.booking.busBooking.dto.BookingRequest;
import com.bus.booking.busBooking.dto.BookingResponse;
import com.bus.booking.busBooking.entities.Booking;
import com.bus.booking.busBooking.entities.Bus;
import com.bus.booking.busBooking.repositories.BookingRepository;
import com.bus.booking.busBooking.repositories.BusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BusRepository busRepository;
    @Override
    public void saveBooking(BookingRequest bookingRequest) {
       Optional <Bus> busOptional = busRepository.findById(bookingRequest.getBusId());
       if(busOptional.isPresent()) {
           Bus bus = busOptional.get();
           java.util.Date utilDate = bookingRequest.getDate();
           java.sql.Date bookingDate = new java.sql.Date(utilDate.getTime());

            // Count the bookings for the specified bus on the booking date
           int bookedSeatsCount = bookingRepository.countByBusAndDate(bus,bookingDate);
           int availableCapacity = bus.getCapacity() - bookedSeatsCount;
           if (availableCapacity >= 1) {
               Booking booking = new Booking();

               BeanUtils.copyProperties(bookingRequest, booking);
               booking.setBus(bus);
               booking.setDate(bookingDate);
               bookingRepository.save(booking);
           } else {
               throw new RuntimeException("Bus is full. Cannot make the booking.");
           }
       }

    }

    @Override
    public boolean existsById(Long id) {
        return bookingRepository.existsById(id);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<BookingResponse> getAllBookings() {
        List<BookingResponse> bookingResponseList = new ArrayList<>();
        List<Booking> bookingList = bookingRepository.findAll();
        for(Booking booking:bookingList){
            BookingResponse bookingResponse =new BookingResponse();
            BeanUtils.copyProperties(booking,bookingResponse);
            bookingResponse.setBusId(booking.getBus().getId());
            bookingResponseList.add(bookingResponse);
        }
        return bookingResponseList;
    }

    @Override
    public boolean existsByBusId(Long id) {
        return bookingRepository.existsByBusId(id);
    }
}
