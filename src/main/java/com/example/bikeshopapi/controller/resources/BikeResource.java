package com.example.bikeshopapi.controller.resources;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BikeResource {

    private Long id;
    private Date created;
    private Date lastModified;
    private String brand;
    private String model;
    private String color;
    private String size;
    private String type;
    private String frame;
    private String fork;
    private String shock;

}
