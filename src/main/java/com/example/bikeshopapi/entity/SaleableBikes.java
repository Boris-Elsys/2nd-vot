package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SaleableBikes {

    @Id
    @GeneratedValue
    private Long id;

    private double price;

    @ManyToOne
    private BikeShop bikeShop;

}
