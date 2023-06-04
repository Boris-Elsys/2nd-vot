package com.example.bikeshopapi.service;

import com.example.bikeshopapi.controller.resources.SaleableBikeResource;

import java.util.List;

public interface SaleableBikeService {

    List<SaleableBikeResource> getAll();
    SaleableBikeResource getById(Long id);
    SaleableBikeResource save(SaleableBikeResource saleableBike);
    SaleableBikeResource update(SaleableBikeResource saleableBike, Long id);
    void delete(Long id);

}
