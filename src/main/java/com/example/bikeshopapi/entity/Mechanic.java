package com.example.bikeshopapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.envers.*;

@Entity
@Data
public class Mechanic extends TemporalBaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long salary;

    @ManyToOne
    @NotAudited
    private BikeShop bikeShop;


}
