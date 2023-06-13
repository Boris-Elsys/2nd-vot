package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.entity.CustomerBike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerBikeMapper {

    CustomerBikeMapper CUSTOMER_BIKE_MAPPER = Mappers.getMapper(CustomerBikeMapper.class);

    @Mapping(source = "ownerId", target = "owner.id")
    @Mapping(source = "bikeShopId", target = "bikeShop.id")
    CustomerBike fromCustomerBikeResource(CustomerBikeResource resource);

    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "bikeShop.id", target = "bikeShopId")
    CustomerBikeResource toCustomerBikeResource(CustomerBike customerBike);

    List<CustomerBikeResource> toCustomerBikeResources(List<CustomerBike> customerBikes);

    List<CustomerBike> fromCustomerBikeResources(List<CustomerBikeResource> customerBikeResources);
}