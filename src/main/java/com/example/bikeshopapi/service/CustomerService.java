package com.example.bikeshopapi.service;

import com.example.bikeshopapi.controller.resources.CustomerResource;

import java.util.List;

public interface CustomerService {

    List<CustomerResource> getAll();
    CustomerResource getById(Long id);
    List<CustomerResource> getAudit(Long id);
    CustomerResource save(CustomerResource customer);
    CustomerResource update(CustomerResource customer, Long id);
    void delete(Long id);

}
