package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.envers.*;

import java.util.List;

@Entity
@Data
public class BikeShop extends TemporalBaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Audited
    private String name;
    @Audited
    private String address;
    @Audited
    private String phone;

    @OneToMany(mappedBy = "bikeShop")
    @NotAudited
    private List<Mechanic> mechanics;
    @OneToMany(mappedBy = "bikeShop")
    @NotAudited
    private List<SaleableBike> saleableBikes;
    @OneToMany(mappedBy = "bikeShop")
    @NotAudited
    private List<Part> parts;
    @OneToMany(mappedBy = "bikeShop")
    @NotAudited
    private List<CustomerBike> customerBikes;

}
