package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomerBike extends Bike {

    @ManyToOne
    private BikeShop bikeShop;

    @ManyToOne
    private Customer owner;
}
