package com.example.bikeshopapi.controller.resources;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BikeShopResource {
    private int id;
    private String name;
    private String address;
    private String phone;
    private Date created;
    private Date lastModified;
    private List<MechanicResource> mechanics;
    private List<SaleableBikeResource> saleableBikes;
    private List<PartResource> parts;
    private List<CustomerBikeResource> customerBikes;
}
