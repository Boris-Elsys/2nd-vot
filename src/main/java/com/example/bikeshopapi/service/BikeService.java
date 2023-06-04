package com.example.bikeshopapi.service;

import com.example.bikeshopapi.controller.resources.BikeResource;

import java.util.List;

public interface BikeService {

    List<BikeResource> getAll();
    BikeResource getById(Long id);
    BikeResource save(BikeResource bike);
    BikeResource update(BikeResource bike, Long id);
    void delete(Long id);

}
