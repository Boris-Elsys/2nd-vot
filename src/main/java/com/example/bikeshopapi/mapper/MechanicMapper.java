package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.MechanicResource;
import com.example.bikeshopapi.entity.Mechanic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MechanicMapper {
    public MechanicMapper MECHANIC_MAPPER = Mappers.getMapper(MechanicMapper.class);
    @Mapping(source = "bikeShop.name", target = "bikeShopName")
    MechanicResource toMechanicResource(Mechanic mechanic);

    @Mapping(source = "bikeShopName", target = "bikeShop.name")//flipped
    Mechanic fromMechanicResource(MechanicResource resource);
    List<MechanicResource> toMechanicResources(List<Mechanic> mechanics);

    List<Mechanic> fromMechanicResources(List<MechanicResource> mechanicResources);
}
