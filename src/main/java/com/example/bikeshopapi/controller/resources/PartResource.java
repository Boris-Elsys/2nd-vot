package com.example.bikeshopapi.controller.resources;

import lombok.Data;

@Data
public class PartResource {

    private Long id;
    private String name;
    private double price;
    private int quantity;
    private Long bikeShopId;
}
