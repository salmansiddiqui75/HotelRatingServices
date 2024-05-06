package com.hotel.controllers;

import com.hotel.entites.Hotel;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController
{
    @Autowired
    private HotelService service;

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> get(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>>  getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
}
