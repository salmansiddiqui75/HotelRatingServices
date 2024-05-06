package com.hotel.services;

import com.hotel.entites.Hotel;
import com.hotel.repositries.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService
{

    //create
    Hotel create(Hotel hotel);


    //get

    Hotel get(String id);

    //getAll

    List<Hotel> getAll();
}
