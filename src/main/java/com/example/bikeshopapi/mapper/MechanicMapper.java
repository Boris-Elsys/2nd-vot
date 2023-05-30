package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.MechanicResource;
import com.example.bikeshopapi.entity.Mechanic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {BikeShopMapper.class})
public interface MechanicMapper {
    public MechanicMapper MECHANIC_MAPPER = Mappers.getMapper(MechanicMapper.class);
    Mechanic fromMechanicResource(MechanicResource resource);
    MechanicResource toMechanicResources(Mechanic mechanic);
    List<MechanicResource> toMechanicResources(List<MechanicMapper> mechanics);

}
