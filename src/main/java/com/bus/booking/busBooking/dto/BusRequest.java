package com.bus.booking.busBooking.dto;

import com.bus.booking.busBooking.enums.Amenities;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusRequest {
    private Long id;
    private int busNo;
    private String busName;
    private int capacity;
    private Amenities amenities;
    private String routeFrom;
    private String routeTo;
}
