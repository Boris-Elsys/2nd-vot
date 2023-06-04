package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.MechanicResource;
import com.example.bikeshopapi.entity.Mechanic;
import com.example.bikeshopapi.repository.BikeShopRepository;
import com.example.bikeshopapi.repository.MechanicRepository;
import com.example.bikeshopapi.service.MechanicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bikeshopapi.mapper.MechanicMapper.MECHANIC_MAPPER;

@Service
@RequiredArgsConstructor
public class MechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;
    private final BikeShopRepository bikeShopRepository;

    @Override
    public MechanicResource getById(Long id) {
        return MECHANIC_MAPPER.toMechanicResource(mechanicRepository.getReferenceById(id));
    }

    @Override
    public List<MechanicResource> getAll() {
        return MECHANIC_MAPPER.toMechanicResources(mechanicRepository.findAll());
    }

    @Override
    public MechanicResource save(MechanicResource mechanicResource) {

        Mechanic mechanicToSave = MECHANIC_MAPPER.fromMechanicResource(mechanicResource);
        mechanicToSave.setId(mechanicResource.getId());
        mechanicToSave.setName(mechanicResource.getName());
        mechanicToSave.setBikeShop(bikeShopRepository.getReferenceByName(mechanicResource.getBikeShopName()));

        return MECHANIC_MAPPER.toMechanicResource(mechanicRepository.save(mechanicToSave));

    }

    @Override
    public MechanicResource update(MechanicResource mechanicResource, Long id) {

            Mechanic mechanicToUpdate = mechanicRepository.getReferenceById(id);
            mechanicToUpdate.setId(mechanicResource.getId());
            mechanicToUpdate.setName(mechanicResource.getName());
            mechanicToUpdate.setBikeShop(bikeShopRepository.getReferenceByName(mechanicResource.getBikeShopName()));

            return MECHANIC_MAPPER.toMechanicResource(mechanicRepository.save(mechanicToUpdate));
    }

    @Override
    public void delete(Long id) {
        mechanicRepository.deleteById(id);
    }
}
