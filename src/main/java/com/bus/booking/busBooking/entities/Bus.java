package com.bus.booking.busBooking.entities;

import com.bus.booking.busBooking.enums.Amenities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long busNo;
    private String busName;
    private int capacity;
    @Enumerated(value = EnumType.STRING)
    private Amenities amenities;
    private String routeFrom;
    private String routeTo;

}
