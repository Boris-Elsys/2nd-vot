package com.example.bikeshopapi.controller.resources;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MechanicResource {

    private Long id;
    private Date created;
    private Date lastModified;
    private String name;
    private Long bikeShopId;
}
