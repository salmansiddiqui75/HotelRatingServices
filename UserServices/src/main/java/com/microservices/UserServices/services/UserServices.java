package com.microservices.UserServices.services;

import com.microservices.UserServices.entities.User;
import com.microservices.UserServices.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices
{
    public User addUser(User user);
    List<User> getAllUser();
    User getUser(String user_id);
}
