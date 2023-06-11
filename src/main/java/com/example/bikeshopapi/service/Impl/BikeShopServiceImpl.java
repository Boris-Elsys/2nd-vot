package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.BikeShopResource;
import com.example.bikeshopapi.repository.BikeShopRepository;
import com.example.bikeshopapi.service.BikeShopService;
import com.example.bikeshopapi.entity.BikeShop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bikeshopapi.mapper.BikeShopMapper.BIKE_SHOP_MAPPER;
import static com.example.bikeshopapi.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static com.example.bikeshopapi.mapper.CustomerBikeMapper.CUSTOMER_BIKE_MAPPER;
import static com.example.bikeshopapi.mapper.MechanicMapper.MECHANIC_MAPPER;
import static com.example.bikeshopapi.mapper.PartMapper.PART_MAPPER;
import static com.example.bikeshopapi.mapper.SaleableBikeMapper.SALEABLE_BIKE_MAPPER;

@Service
@RequiredArgsConstructor
public class BikeShopServiceImpl implements BikeShopService {

    private final BikeShopRepository bikeShopRepository;

    @Override
    public BikeShopResource getById(Long id) {
        return BIKE_SHOP_MAPPER.toBikeShopResource(bikeShopRepository.getReferenceById(id));
    }

    @Override
    public List<BikeShopResource> getAll() {
        return BIKE_SHOP_MAPPER.toBikeShopResources(bikeShopRepository.findAll());
    }

    @Override
    public BikeShopResource save(BikeShopResource bikeShopResource) {

        BikeShop bikeShopToSave = BIKE_SHOP_MAPPER.fromBikeShopResource(bikeShopResource);
        bikeShopToSave.setName(bikeShopResource.getName());
        bikeShopToSave.setAddress(bikeShopResource.getAddress());
        bikeShopToSave.setPhone(bikeShopResource.getPhone());
        bikeShopToSave.setMechanics(MECHANIC_MAPPER.fromMechanicResources(bikeShopResource.getMechanics()));
        bikeShopToSave.setSaleableBikes(SALEABLE_BIKE_MAPPER.fromSaleableBikeResources(bikeShopResource.getSaleableBikes()));
        bikeShopToSave.setParts(PART_MAPPER.fromPartResources(bikeShopResource.getParts()));

        return BIKE_SHOP_MAPPER.toBikeShopResource(bikeShopRepository.save(bikeShopToSave));

    }

    @Override
    public BikeShopResource update(BikeShopResource bikeShopResource, Long id) {

        BikeShop bikeShopToUpdate = bikeShopRepository.getReferenceById(id);
        bikeShopToUpdate.setName(bikeShopResource.getName());
        bikeShopToUpdate.setAddress(bikeShopResource.getAddress());
        bikeShopToUpdate.setPhone(bikeShopResource.getPhone());
        bikeShopToUpdate.setMechanics(MECHANIC_MAPPER.fromMechanicResources(bikeShopResource.getMechanics()));
        bikeShopToUpdate.setSaleableBikes(SALEABLE_BIKE_MAPPER.fromSaleableBikeResources(bikeShopResource.getSaleableBikes()));
        bikeShopToUpdate.setParts(PART_MAPPER.fromPartResources(bikeShopResource.getParts()));
        bikeShopToUpdate.setCustomerBikes(CUSTOMER_BIKE_MAPPER.fromCustomerBikeResources(bikeShopResource.getCustomerBikes()));

        return BIKE_SHOP_MAPPER.toBikeShopResource(bikeShopRepository.save(bikeShopToUpdate));
    }

    @Override
    public void delete(Long id) {
        bikeShopRepository.deleteById(id);
    }

}
