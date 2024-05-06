package com.rating.controllers;

import com.rating.entites.Rating;
import com.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController
{
    @Autowired
    private RatingService service;

    //create

    @PostMapping()
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
    }

    //Get All

    @GetMapping
    public ResponseEntity<List<Rating>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllRating());
    }

    //Get rating by UserId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByUserId(userId));
    }

    //Get rating by hotelId

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByHotelId(hotelId));
    }
}
