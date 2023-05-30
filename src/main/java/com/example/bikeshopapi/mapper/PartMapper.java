package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.PartResource;
import com.example.bikeshopapi.entity.Part;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {BikeShopMapper.class})
public interface PartMapper {
    public PartMapper MECHANIC_MAPPER = Mappers.getMapper(PartMapper.class);

    Part fromPartResource(PartResource resource);

    PartResource toPartResources(Part part);

    List<PartResource> toPartResources(List<PartMapper> parts);

}