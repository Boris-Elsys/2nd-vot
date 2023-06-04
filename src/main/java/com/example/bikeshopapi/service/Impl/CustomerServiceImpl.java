package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.controller.resources.CustomerResource;
import com.example.bikeshopapi.repository.CustomerRepository;
import com.example.bikeshopapi.service.CustomerService;
import com.example.bikeshopapi.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bikeshopapi.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static com.example.bikeshopapi.mapper.CustomerBikeMapper.CUSTOMER_BIKE_MAPPER;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResource getById(Long id) {
        return CUSTOMER_MAPPER.toCustomerResource(customerRepository.getReferenceById(id));
    }

    @Override
    public List<CustomerResource> getAll() {
        return CUSTOMER_MAPPER.toCustomerResources(customerRepository.findAll());
    }

    @Override
    public CustomerResource save(CustomerResource customerResource) {

        Customer customerToSave = CUSTOMER_MAPPER.fromCustomerResource(customerResource);
        customerToSave.setId(customerResource.getId());
        customerToSave.setCustomerBikes(CUSTOMER_BIKE_MAPPER.fromCustomerBikeResources(customerResource.getCustomerBikes()));
        customerToSave.setName(customerResource.getName());

        return CUSTOMER_MAPPER.toCustomerResource(customerRepository.save(customerToSave));
    }

    @Override
    public CustomerResource update(CustomerResource customerResource, Long id) {
        Customer customerToUpdate = customerRepository.getReferenceById(id);
        customerToUpdate.setName(customerResource.getName());
        customerToUpdate.setCustomerBikes(CUSTOMER_BIKE_MAPPER.fromCustomerBikeResources(customerResource.getCustomerBikes()));

        return CUSTOMER_MAPPER.toCustomerResource(customerRepository.save(customerToUpdate));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

}
