package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.entity.CustomerBike;
import com.example.bikeshopapi.repository.CustomerBikeRepository;
import com.example.bikeshopapi.service.CustomerBikeService;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.hibernate.envers.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.bikeshopapi.mapper.CustomerBikeMapper.CUSTOMER_BIKE_MAPPER;

@Service
@RequiredArgsConstructor
public class CustomerBikeServiceImpl implements CustomerBikeService {
    private final CustomerBikeRepository customerBikeRepository;
    private final EntityManagerFactory entityManager;

    @Override
    public CustomerBikeResource getById(Long id) {
        return CUSTOMER_BIKE_MAPPER.toCustomerBikeResource(customerBikeRepository.getReferenceById(id));
    }

    @Override
    public List<CustomerBikeResource> getAll() {
        return CUSTOMER_BIKE_MAPPER.toCustomerBikeResources(customerBikeRepository.findAll());
    }

    @Override
    public List<CustomerBikeResource> getAudit(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(CustomerBike.class, id);
        List<CustomerBike> customerBikes = new ArrayList<>();
        for (Number revision : revisions) {
            CustomerBike customerBike = auditReader.find(CustomerBike.class, id, revision);
            customerBikes.add(customerBike);
        }
        return CUSTOMER_BIKE_MAPPER.toCustomerBikeResources(customerBikes);

    }

    @Override
    public CustomerBikeResource save(CustomerBikeResource customerBikeResource) {

        CustomerBike customerBikeToSave = CUSTOMER_BIKE_MAPPER.fromCustomerBikeResource(customerBikeResource);
        customerBikeToSave.setBikeShop(customerBikeToSave.getBikeShop());
        customerBikeToSave.setCreated(customerBikeToSave.getCreated());
        customerBikeToSave.setLastModified(customerBikeToSave.getLastModified());
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
        customerBikeToUpdate.setBikeShop(customerBikeToUpdate.getBikeShop());
        customerBikeToUpdate.setOwner(customerBikeToUpdate.getOwner());
        customerBikeToUpdate.setCreated(customerBikeToUpdate.getCreated());
        customerBikeToUpdate.setLastModified(customerBikeToUpdate.getLastModified());
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
