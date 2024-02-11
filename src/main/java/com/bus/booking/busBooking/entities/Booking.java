package com.bus.booking.busBooking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String passenger;
    private Date date;
    private int mobileNo;
    private String emailAddress;
    @ManyToOne
    @JoinColumn(name="bus_id",nullable = false)
    private Bus bus;

}
