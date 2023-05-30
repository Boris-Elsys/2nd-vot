package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.BikeShopResource;
import com.example.bikeshopapi.entity.BikeShop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {MechanicMapper.class, CustomerMapper.class, SaleableBikeMapper.class, PartMapper.class, CustomerBikeMapper.class})
public interface BikeShopMapper {

    public BikeShopMapper BIKE_SHOP_MAPPER = Mappers.getMapper(BikeShopMapper.class);
    BikeShop fromBikeShopResource(BikeShopResource bikeShopResource);
    BikeShopResource toBikeShopResource(BikeShop bikeShop);
    List<BikeShopResource> toBikeShopResources(List<BikeShop> BikeShops);

}
