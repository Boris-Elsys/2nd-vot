package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.envers.*;

@Entity
@Data
public class CustomerBike extends Bike {

    @ManyToOne
    @NotAudited
    private BikeShop bikeShop;

    @ManyToOne
    @NotAudited
    private Customer owner;

    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }

}
