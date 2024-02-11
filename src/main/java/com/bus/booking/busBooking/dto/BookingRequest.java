package com.bus.booking.busBooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class BookingRequest {
    private Long id;
    private String passenger;
    private Date date;
    private int mobileNo;
    private String emailAddress;
    private Long busId;
}
