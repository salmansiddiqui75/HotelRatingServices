package com.hotel.services.impl;

import com.hotel.entites.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repositries.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService
{

    @Autowired
    private HotelRepository repository;
    @Override
    public Hotel create(Hotel hotel)
    {
        String id=UUID.randomUUID().toString();
        hotel.setId(id);
        return repository.save(hotel);
    }

    @Override
    public Hotel get(String id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel not found with given id !!"));
    }

    @Override
    public List<Hotel> getAll() {
        return repository.findAll();
    }
}
