package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SaleableBike extends Bike {

    @Id
    @GeneratedValue
    private Long id;

    private double price;

    @ManyToOne
    private BikeShop bikeShop;

}
