package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.PartResource;
import com.example.bikeshopapi.entity.Part;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {BikeShopMapper.class})
public interface PartMapper {
    public PartMapper PART_MAPPER = Mappers.getMapper(PartMapper.class);
    @Mapping(source = "bikeShop.name", target = "bikeShopName")
    Part fromPartResource(PartResource resource);
    @Mapping(source = "bikeShopName", target = "bikeShop.name")
    PartResource toPartResource(Part part);

    List<PartResource> toPartResources(List<Part> parts);

    List<Part> fromPartResources(List<PartResource> partResources);

}