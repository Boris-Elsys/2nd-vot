package com.example.bikeshopapi.service;

import com.example.bikeshopapi.controller.resources.BikeShopResource;

import java.util.List;

public interface BikeShopService {

    List<BikeShopResource> getAll();
    BikeShopResource getById(Long id);
    BikeShopResource save(BikeShopResource bikeShop);
    BikeShopResource update(BikeShopResource bikeShop, Long id);
    void delete(Long id);

}
