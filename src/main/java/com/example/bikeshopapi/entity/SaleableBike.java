package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.envers.*;

@Entity
@Data
public class SaleableBike extends Bike {

    @Audited
    private double price;

    @ManyToOne
    @NotAudited
    private BikeShop bikeShop;


}
