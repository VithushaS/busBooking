package com.bus.booking.busBooking.controller;

import com.bus.booking.busBooking.EndpointURI;
import com.bus.booking.busBooking.dto.BusRequest;
import com.bus.booking.busBooking.service.BusService;
import com.bus.booking.busBooking.util.StatusCodeBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BusController {
    @Autowired
    private StatusCodeBundle statusCodeBundle;
    @Autowired
   private BusService busService;
@PostMapping(value = EndpointURI.BUS_DETAILS)
    public ResponseEntity<Object> addBus(@RequestBody BusRequest busRequest){
    if(busService.checkExistsBusNo(busRequest.getBusNo())){
        String message = "Bus No Already Exists";
        return ResponseEntity.ok(message);
    }
    busService.saveBus(busRequest);
    String message = "Bus create successfully";
    return ResponseEntity.ok(message);
}
@GetMapping(value = EndpointURI.BUSES)
    public ResponseEntity<Object> getAllBuses(){
    return ResponseEntity.ok().body(busService.getAllBuses());
}
@PutMapping(value = EndpointURI.BUS_DETAILS)
    public ResponseEntity<Object> updateBus(@RequestBody BusRequest busRequest){
    if(!busService.existsById(busRequest.getId())){
        return ResponseEntity.ok("Bus not exists");
    }
    busService.saveBus(busRequest);
    return ResponseEntity.ok("updated successfully");
}

}
