package com.example.bikeshopapi.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Bike {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String model;
    private String color;
    private String size;
    private String type;
    private String frame;
    private String fork;
    private String shock;


}
