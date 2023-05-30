package com.example.bikeshopapi.controller.resources;

import lombok.Data;

import java.util.List;

@Data
public class CustomerResource {
    private int id;
    private String name;
    private List<CustomerBikeResource> customerBikes;
}
