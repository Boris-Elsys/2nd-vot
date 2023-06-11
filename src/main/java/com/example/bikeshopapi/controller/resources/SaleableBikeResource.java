package com.example.bikeshopapi.controller.resources;

import lombok.Data;

@Data
public class SaleableBikeResource extends BikeResource {

    private Long bikeShopId;
    private double price;

}
