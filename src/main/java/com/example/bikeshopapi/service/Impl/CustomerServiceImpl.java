package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.controller.resources.CustomerResource;
import com.example.bikeshopapi.repository.CustomerRepository;
import com.example.bikeshopapi.service.CustomerService;
import com.example.bikeshopapi.entity.Customer;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.hibernate.envers.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.bikeshopapi.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static com.example.bikeshopapi.mapper.CustomerBikeMapper.CUSTOMER_BIKE_MAPPER;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final EntityManagerFactory entityManager;

    @Override
    public CustomerResource getById(Long id) {
        return CUSTOMER_MAPPER.toCustomerResource(customerRepository.getReferenceById(id));
    }

    @Override
    public List<CustomerResource> getAll() {
        return CUSTOMER_MAPPER.toCustomerResources(customerRepository.findAll());
    }

    @Override
    public List<CustomerResource> getAudit(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(Customer.class, id);
        List<Customer> customers = new ArrayList<>();
        for (Number revision : revisions) {
            Customer customer = auditReader.find(Customer.class, id, revision);
            customers.add(customer);
        }
        return CUSTOMER_MAPPER.toCustomerResources(customers);
    }

    @Override
    public CustomerResource save(CustomerResource customerResource) {

        Customer customerToSave = CUSTOMER_MAPPER.fromCustomerResource(customerResource);
        customerToSave.setCustomerBikes(CUSTOMER_BIKE_MAPPER.fromCustomerBikeResources(customerResource.getCustomerBikes()));
        customerToSave.setName(customerResource.getName());

        return CUSTOMER_MAPPER.toCustomerResource(customerRepository.save(customerToSave));
    }

    @Override
    public CustomerResource update(CustomerResource customerResource, Long id) {
        Customer customerToUpdate = customerRepository.getReferenceById(id);
        customerToUpdate.setName(customerResource.getName());
        customerToUpdate.setCustomerBikes(CUSTOMER_BIKE_MAPPER.fromCustomerBikeResources(customerResource.getCustomerBikes()));
        customerToUpdate.setCreated(customerResource.getCreated());
        customerToUpdate.setLastModified(customerResource.getLastModified());

        return CUSTOMER_MAPPER.toCustomerResource(customerRepository.save(customerToUpdate));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

}
