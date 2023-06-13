package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.envers.*;

@Entity
@Data
public class Part extends TemporalBaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotAudited
    private BikeShop bikeShop;

    private String name;
    private double price;
    private int quantity;

}
