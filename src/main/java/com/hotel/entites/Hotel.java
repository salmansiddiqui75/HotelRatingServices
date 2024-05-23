package com.hotel.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel
{
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
