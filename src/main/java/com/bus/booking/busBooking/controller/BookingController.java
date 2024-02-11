package com.bus.booking.busBooking.controller;

import com.bus.booking.busBooking.EndpointURI;
import com.bus.booking.busBooking.dto.BookingRequest;
import com.bus.booking.busBooking.service.BookingService;
import com.bus.booking.busBooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    BusService busService;

    @PostMapping(EndpointURI.BUS_BOOKING)
    public ResponseEntity<Object> addBooking(@RequestBody BookingRequest bookingRequest){
        if(!busService.existsById(bookingRequest.getBusId())){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("bus not exists");
        }
        try {
            bookingService.saveBooking(bookingRequest);
            return ResponseEntity.ok("Booking successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping(EndpointURI.CANCELL_BOOKING)
    public ResponseEntity<Object> deleteBooking(@PathVariable Long id){
        if(!bookingService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not exists");
        }
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("booking cancelled successfully");
    }
    @GetMapping(EndpointURI.ALL_BOOKINGS)
    public ResponseEntity<Object> getAllBookings(){
        return ResponseEntity.ok().body(bookingService.getAllBookings());
    }
}
