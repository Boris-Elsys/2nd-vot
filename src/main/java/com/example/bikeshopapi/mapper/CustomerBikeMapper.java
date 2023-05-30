package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.entity.CustomerBike;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CustomerMapper.class, BikeShopMapper.class})
public interface CustomerBikeMapper {
    public CustomerBikeMapper CUSTOMER_BIKE_MAPPER = Mappers.getMapper(CustomerBikeMapper.class);
    CustomerBike fromCustomerBikeResource(CustomerBikeResource resource);
    CustomerBikeResource toCustomerBikeResources(CustomerBike customerBike);
    List<CustomerBikeResource> toCustomerBikeResources(List<CustomerBike> customerBikes);

}