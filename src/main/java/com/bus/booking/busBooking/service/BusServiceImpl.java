package com.bus.booking.busBooking.service;

import com.bus.booking.busBooking.dto.BusRequest;
import com.bus.booking.busBooking.dto.BusRespose;
import com.bus.booking.busBooking.entities.Bus;
import com.bus.booking.busBooking.repositories.BusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean checkExistsBusNo(Long busNo) {
        return busRepository.existsByBusNo(busNo);
    }

    @Override
    public List<BusRespose> getAllBuses() {
       List<BusRespose> busResposeList = new ArrayList<>();
       List<Bus> busList = busRepository.findAll();
       for(Bus bus: busList){
           BusRespose busRespose=new BusRespose();
           BeanUtils.copyProperties(bus,busRespose);
           busResposeList.add(busRespose);
       }
        return busResposeList;
    }

    @Override
    public boolean existsById(Long id) {
        return busRepository.existsById(id);
    }

    @Override
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }
}
