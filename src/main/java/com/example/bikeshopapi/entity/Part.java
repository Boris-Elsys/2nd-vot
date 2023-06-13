package com.example.bikeshopapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Part extends TemporalBaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private BikeShop bikeShop;

    private String name;
    private double price;
    private int quantity;

}
