package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
    private BikeShop bikeShop;
    @OneToMany
    private List<CustomerBike> customerBikes;

}
