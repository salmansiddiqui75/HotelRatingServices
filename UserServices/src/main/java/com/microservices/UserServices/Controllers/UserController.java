package com.microservices.UserServices.Controllers;

import com.microservices.UserServices.entities.User;
import com.microservices.UserServices.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserServices userServices;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1=userServices.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name="ratingHotelBreaker" , fallbackMethod = "ratingHotelFallBackMethod")
    public ResponseEntity<User> getUser(@PathVariable String userId)
    {
        User user=userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //fallback method of ratingHotelBreaker
    public ResponseEntity<User> ratingHotelFallBackMethod(String id,Exception ex)
    {
        User user = User.builder().email("dummy@gmail.com").name("dummy").about("This is dummy user").userId("1234").build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> user=userServices.getAllUser();
        return ResponseEntity.ok(user);
    }
}
