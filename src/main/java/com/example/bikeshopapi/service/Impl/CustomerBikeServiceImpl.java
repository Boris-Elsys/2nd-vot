package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.entity.CustomerBike;
import com.example.bikeshopapi.repository.CustomerBikeRepository;
import com.example.bikeshopapi.service.CustomerBikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bikeshopapi.mapper.CustomerBikeMapper.CUSTOMER_BIKE_MAPPER;

@Service
@RequiredArgsConstructor
public class CustomerBikeServiceImpl implements CustomerBikeService {
    private final CustomerBikeRepository customerBikeRepository;
    @Override
    public CustomerBikeResource getById(Long id) {
        return CUSTOMER_BIKE_MAPPER.toCustomerBikeResource(customerBikeRepository.getReferenceById(id));
    }

    @Override
    public List<CustomerBikeResource> getAll() {
        return CUSTOMER_BIKE_MAPPER.toCustomerBikeResources(customerBikeRepository.findAll());
    }

    @Override
    public CustomerBikeResource save(CustomerBikeResource customerBikeResource) {

        CustomerBike customerBikeToSave = CUSTOMER_BIKE_MAPPER.fromCustomerBikeResource(customerBikeResource);
        customerBikeToSave.setId(customerBikeToSave.getId());
        customerBikeToSave.setBikeShop(customerBikeToSave.getBikeShop());
        customerBikeToSave.setOwner(customerBikeToSave.getOwner());
        customerBikeToSave.setBrand(customerBikeToSave.getBrand());
        customerBikeToSave.setModel(customerBikeToSave.getModel());
        customerBikeToSave.setColor(customerBikeToSave.getColor());
        customerBikeToSave.setSize(customerBikeToSave.getSize());
        customerBikeToSave.setType(customerBikeToSave.getType());
        customerBikeToSave.setFrame(customerBikeToSave.getFrame());
        customerBikeToSave.setFork(customerBikeToSave.getFork());
        customerBikeToSave.setShock(customerBikeToSave.getShock());

        return CUSTOMER_BIKE_MAPPER.toCustomerBikeResource(customerBikeRepository.save(customerBikeToSave));
    }

    @Override
    public CustomerBikeResource update(CustomerBikeResource customerBikeResource, Long id) {

        CustomerBike customerBikeToUpdate = customerBikeRepository.getReferenceById(id);
        customerBikeToUpdate.setId(customerBikeToUpdate.getId());
        customerBikeToUpdate.setBikeShop(customerBikeToUpdate.getBikeShop());
        customerBikeToUpdate.setOwner(customerBikeToUpdate.getOwner());
        customerBikeToUpdate.setBrand(customerBikeToUpdate.getBrand());
        customerBikeToUpdate.setModel(customerBikeToUpdate.getModel());
        customerBikeToUpdate.setColor(customerBikeToUpdate.getColor());
        customerBikeToUpdate.setSize(customerBikeToUpdate.getSize());
        customerBikeToUpdate.setType(customerBikeToUpdate.getType());
        customerBikeToUpdate.setFrame(customerBikeToUpdate.getFrame());
        customerBikeToUpdate.setFork(customerBikeToUpdate.getFork());
        customerBikeToUpdate.setShock(customerBikeToUpdate.getShock());

        return CUSTOMER_BIKE_MAPPER.toCustomerBikeResource(customerBikeRepository.save(customerBikeToUpdate));
    }

    @Override
    public void delete(Long id) {
        customerBikeRepository.deleteById(id);
    }
}
