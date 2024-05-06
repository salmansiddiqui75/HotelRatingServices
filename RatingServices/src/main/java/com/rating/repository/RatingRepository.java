package com.rating.repository;

import com.rating.entites.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String>
{
    List<Rating> findByuserId(String userid);
    List<Rating> findByhotelId(String hotelId);
}
