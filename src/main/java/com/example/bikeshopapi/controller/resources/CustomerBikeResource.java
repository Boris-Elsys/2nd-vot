package com.example.bikeshopapi.controller.resources;

import lombok.Data;

@Data
public class CustomerBikeResource extends BikeResource {

    private Long bikeShopId;
    private Long ownerId;
}
