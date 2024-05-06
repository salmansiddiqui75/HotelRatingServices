package com.microservices.UserServices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_user")
public class User
{
    @Id
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Ratings> rating=new ArrayList<>();
}
