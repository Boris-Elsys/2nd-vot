package com.example.bikeshopapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class CustomerBike {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Customer owner;
}
