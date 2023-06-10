package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.MechanicResource;
import com.example.bikeshopapi.entity.Mechanic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {BikeShopMapper.class})
public interface MechanicMapper {
    public MechanicMapper MECHANIC_MAPPER = Mappers.getMapper(MechanicMapper.class);
    @Mapping(source = "bikeShop.name", target = "bikeShopName")
    Mechanic fromMechanicResource(MechanicResource resource);

    @Mapping(source = "bikeShopName", target = "bikeShop.name")
    MechanicResource toMechanicResource(Mechanic mechanic);
    List<MechanicResource> toMechanicResources(List<Mechanic> mechanics);

    List<Mechanic> fromMechanicResources(List<MechanicResource> mechanicResources);
}
