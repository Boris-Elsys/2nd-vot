package com.example.bikeshopapi.controller.resources;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MechanicResource {

    private Long id;
    private String name;
    private String bikeShopName;
}
