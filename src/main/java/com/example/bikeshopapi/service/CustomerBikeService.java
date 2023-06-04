package com.example.bikeshopapi.service;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;

import java.util.List;

public interface CustomerBikeService{

    List<CustomerBikeResource> getAll();
    CustomerBikeResource getById(Long id);
    CustomerBikeResource save(CustomerBikeResource customerBike);
    CustomerBikeResource update(CustomerBikeResource customerBike, Long id);
    void delete(Long id);

}
