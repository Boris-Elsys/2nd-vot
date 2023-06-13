package com.example.bikeshopapi.controller.resources;

import lombok.Data;

import java.util.Date;

@Data
public class PartResource {

    private Long id;
    private Date created;
    private Date lastModified;
    private String name;
    private double price;
    private int quantity;
    private Long bikeShopId;
}
