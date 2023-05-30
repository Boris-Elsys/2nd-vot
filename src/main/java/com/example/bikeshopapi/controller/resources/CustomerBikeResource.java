package com.example.bikeshopapi.controller.resources;

import lombok.Data;

@Data
public class CustomerBikeResource extends BikeResource {

    private String bikeShopName;
    private String ownerName;
}
