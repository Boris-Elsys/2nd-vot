package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SaleableBike extends Bike {

    private double price;

    @ManyToOne
    private BikeShop bikeShop;

}
