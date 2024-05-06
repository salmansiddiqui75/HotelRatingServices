package com.microservices.UserServices.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel
{
    @Id
    private String id;
    private String name;
    private String location;
    private String about;


}
