package com.microservices.UserServices.services.ServiceImpl;

import com.microservices.UserServices.entities.Hotel;
import com.microservices.UserServices.entities.Ratings;
import com.microservices.UserServices.entities.User;
import com.microservices.UserServices.exception.ResourceNotFound;
import com.microservices.UserServices.feignClient.HotelService;
import com.microservices.UserServices.repository.UserRepo;
import com.microservices.UserServices.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices
{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    private Logger logger= LoggerFactory.getLogger(UserServices.class);

    @Override
    public User addUser(User user)
    {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUser(String user_id) {
        User user=this.userRepo.findById(user_id).orElseThrow(()->new ResourceNotFound("User with the given id is not found on server "+user_id));

        //to fetch user with rating

        Ratings[] ratings = restTemplate.getForObject("http://RATINGSERVICES/rating/user/"+user.getUserId(),Ratings[].class);
        logger.info("{}",ratings);

        List<Ratings> list = Arrays.asList(ratings);

        user.setRating(list);

        //api to call the hotel service
        //set the hotel to rating
        //return the rating
        //set rating to the user
        List<Ratings> collect = list.stream().map(ratings1 ->
                {
                    //hotel url localhost:8082/hotel/9682230b-aa36-4f5e-8424-65993744dd8a
                    //Instead of using rest template now we are using Feign client below code
                    //Hotel hotelResponseEntity = restTemplate.getForObject("http://HOTELSERVICE/hotel/" + ratings1.getHotelId(), Hotel.class);

                    Hotel hotel=hotelService.getHotel(ratings1.getHotelId());
                    ratings1.setHotel(hotel);
                    return ratings1;
                }
        ).collect(Collectors.toList());
        user.setRating(collect);
        return user;
    }
}
