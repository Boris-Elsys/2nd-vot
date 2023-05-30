package com.example.bikeshopapi.mapper;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.entity.CustomerBike;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = CustomerMapper.class)
public interface CustomerBikeMapper {
    public CustomerBikeMapper CUSTOMER_BIKE_MAPPER = Mappers.getMapper(CustomerBikeMapper.class);
/*Subject fromSubjectResource(SubjectResource resource);

    SubjectResource toSubjectResource(Subject subject);

    List<SubjectResource> toSubjectResources(List<Subject> subjects);*/
    CustomerBike fromCustomerBikeResource(CustomerBikeResource resource);
    CustomerBikeResource toCustomerBikeRecources(CustomerBike customerBike);
    List<CustomerBikeResource> toCustomerBikeResources(List<CustomerBike> customer);


}
