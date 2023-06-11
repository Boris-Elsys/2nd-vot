package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.MechanicResource;
import com.example.bikeshopapi.entity.Mechanic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MechanicMapper {
    MechanicMapper MECHANIC_MAPPER = Mappers.getMapper(MechanicMapper.class);

    @Mapping(source = "bikeShop.id", target = "bikeShopId")
    MechanicResource toMechanicResource(Mechanic mechanic);

    @Mapping(source = "bikeShopId", target = "bikeShop.id")//flipped
    Mechanic fromMechanicResource(MechanicResource resource);
    List<MechanicResource> toMechanicResources(List<Mechanic> mechanics);

    List<Mechanic> fromMechanicResources(List<MechanicResource> mechanicResources);
}
