package com.bus.booking.busBooking.service;

import com.bus.booking.busBooking.dto.BusRequest;
import com.bus.booking.busBooking.entities.Bus;
import com.bus.booking.busBooking.repositories.BusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService{
    @Autowired
    BusRepository busRepository;
    @Override
    public void saveBus(BusRequest busRequest) {
        Bus bus=new Bus();
        BeanUtils.copyProperties(busRequest,bus);
        busRepository.save(bus);
    }
}
