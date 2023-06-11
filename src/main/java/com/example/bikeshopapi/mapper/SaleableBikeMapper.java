package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.SaleableBikeResource;
import com.example.bikeshopapi.entity.SaleableBike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SaleableBikeMapper {
    SaleableBikeMapper SALEABLE_BIKE_MAPPER = Mappers.getMapper(SaleableBikeMapper.class);

    @Mapping(source = "bikeShopName", target = "bikeShop.name")
    SaleableBike fromSaleableBikeResource(SaleableBikeResource resource);

    @Mapping(source = "bikeShop.name", target = "bikeShopName")
    SaleableBikeResource toSaleableBikeResource(SaleableBike saleableBike);
    List<SaleableBikeResource> toSaleableBikeResources(List<SaleableBike> saleableBikes);
    List<SaleableBike> fromSaleableBikeResources(List<SaleableBikeResource> saleableBikeResources);

}