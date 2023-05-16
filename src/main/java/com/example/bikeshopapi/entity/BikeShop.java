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

    @OneToMany
    private List<Mechanic> mechanics;
    @OneToMany
    private List<Customer> customers;
    @OneToMany
    private List<SaleableBike> saleableBikes;
    @OneToMany
    private List<Part> parts;
    @OneToMany
    private List<CustomerBike> customerBikes;


}
