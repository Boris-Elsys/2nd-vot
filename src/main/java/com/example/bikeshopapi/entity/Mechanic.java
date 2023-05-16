package com.example.bikeshopapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Mechanic {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
    private BikeShop bikeShop;




}
