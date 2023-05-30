package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.SaleableBikeResource;
import com.example.bikeshopapi.entity.SaleableBike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {BikeShopMapper.class})
public interface SaleableBikeMapper {
    public SaleableBikeMapper SALEABLE_BIKE_MAPPER = Mappers.getMapper(SaleableBikeMapper.class);

    @Mapping(source = "bikeShop.name", target = "bikeShopName")
    SaleableBike fromSaleableBikeResource(SaleableBikeResource resource);

    @Mapping(source = "bikeShopName", target = "bikeShop.name")
    SaleableBikeResource toSaleableBikeResources(SaleableBike saleableBike);
    List<SaleableBikeResource> toSaleableBikeResources(List<SaleableBike> saleableBikes);

}