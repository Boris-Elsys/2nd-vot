package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.entity.CustomerBike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerBikeMapper {

    public CustomerBikeMapper CUSTOMER_BIKE_MAPPER = Mappers.getMapper(CustomerBikeMapper.class);

    @Mapping(source = "ownerName", target = "owner.name")
    @Mapping(source = "bikeShopName", target = "bikeShop.name")
    CustomerBike fromCustomerBikeResource(CustomerBikeResource resource);

    @Mapping(source = "owner.name", target = "ownerName")
    @Mapping(source = "bikeShop.name", target = "bikeShopName")
    CustomerBikeResource toCustomerBikeResource(CustomerBike customerBike);

    List<CustomerBikeResource> toCustomerBikeResources(List<CustomerBike> customerBikes);

    List<CustomerBike> fromCustomerBikeResources(List<CustomerBikeResource> customerBikeResources);

}