package com.microservices.UserServices.repository;

import com.microservices.UserServices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User,String>
{

}
