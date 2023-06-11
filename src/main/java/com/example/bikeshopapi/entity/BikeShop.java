package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class BikeShop {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "bikeShop")
    private List<Mechanic> mechanics;
    @OneToMany(mappedBy = "bikeShop")
    private List<SaleableBike> saleableBikes;
    @OneToMany(mappedBy = "bikeShop")
    private List<Part> parts;
    @OneToMany(mappedBy = "bikeShop")
    private List<CustomerBike> customerBikes;


}
