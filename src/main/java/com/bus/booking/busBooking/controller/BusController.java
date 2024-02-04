package com.bus.booking.busBooking.controller;

import com.bus.booking.busBooking.EndpointURI;
import com.bus.booking.busBooking.dto.BusRequest;
import com.bus.booking.busBooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BusController {
    @Autowired
   private BusService busService;
@PostMapping(value = EndpointURI.BUS_DETAILS)
    public ResponseEntity<Object> addBus(@RequestBody BusRequest busRequest){
    busService.saveBus(busRequest);
    String message = "Bus create successfully";
    return ResponseEntity.ok(message);
}
}
