package com.rating.services;

import com.rating.entites.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService
{
    //create

    Rating create(Rating rating);

    //Get all rating

    List<Rating> getAllRating();

    //Get rating by userId

    List<Rating> getRatingByUserId(String userId);

    //Get rating by hotelId

    List<Rating> getRatingByHotelId(String hotelId);
}
