package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.CustomerResource;
import com.example.bikeshopapi.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CustomerBikeMapper.class})
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "lastModified", ignore = true)
    Customer fromCustomerResource(CustomerResource customerResource);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "lastModified", ignore = true)
    CustomerResource toCustomerResource(Customer customer);
    List<CustomerResource> toCustomerResources(List<Customer> customers);
    List<Customer> fromCustomerResources(List<CustomerResource> customerResources);

}
