package com.example.bikeshopapi.service;

import com.example.bikeshopapi.controller.resources.MechanicResource;

import java.util.List;

public interface MechanicService {

    List<MechanicResource> getAll();
    MechanicResource getById(Long id);
    List<MechanicResource> getAudit(Long id);
    MechanicResource save(MechanicResource mechanic);
    MechanicResource update(MechanicResource mechanic, Long id);
    void delete(Long id);

}
