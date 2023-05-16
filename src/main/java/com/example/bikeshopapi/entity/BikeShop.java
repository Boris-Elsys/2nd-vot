package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Entity
@Data
public class BikeShop {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String address;

    @OneToMany
    private List<Mechanic> mechanics;
    @OneToMany
    private List<Customer> customers;
    @OneToMany
    private List<SaleableBikes> saleableBikes;
    @OneToMany
    private List<Parts> parts;
    @OneToMany
    private List<CustomerBikes> customerBikes;


}
