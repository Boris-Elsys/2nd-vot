package com.example.bikeshopapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Mechanic extends TemporalBaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long salary;

    @ManyToOne
    private BikeShop bikeShop;

}
