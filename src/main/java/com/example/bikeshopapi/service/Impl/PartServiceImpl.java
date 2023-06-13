package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.PartResource;
import com.example.bikeshopapi.entity.Part;
import com.example.bikeshopapi.repository.BikeShopRepository;
import com.example.bikeshopapi.repository.PartRepository;
import com.example.bikeshopapi.service.PartService;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.hibernate.envers.*;


import java.util.List;
import java.util.ArrayList;

import static com.example.bikeshopapi.mapper.PartMapper.PART_MAPPER;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final BikeShopRepository bikeShopRepository;
    private final EntityManagerFactory entityManager;

    @Override
    public PartResource getById(Long id) {
        return PART_MAPPER.toPartResource(partRepository.getReferenceById(id));
    }

    @Override
    public List<PartResource> getAll() {
        return PART_MAPPER.toPartResources(partRepository.findAll());
    }

    @Override
    public List<PartResource> getAudit(Long id){

        AuditReader auditReader = AuditReaderFactory.get(entityManager.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(Part.class, id);
        List<Part> parts = new ArrayList<>();
        for (Number revision : revisions) {
            Part part = auditReader.find(Part.class, id, revision);
            parts.add(part);
        }
        return PART_MAPPER.toPartResources(parts);

    }

    @Override
    public PartResource save(PartResource partResource) {

        Part partToSave = PART_MAPPER.fromPartResource(partResource);
        partToSave.setName(partResource.getName());
        partToSave.setPrice(partResource.getPrice());
        partToSave.setQuantity(partResource.getQuantity());
        partToSave.setBikeShop(bikeShopRepository.getReferenceById(partResource.getBikeShopId()));

        return PART_MAPPER.toPartResource(partRepository.save(partToSave));

    }

    @Override
    public PartResource update(PartResource partResource, Long id) {

            Part partToUpdate = partRepository.getReferenceById(id);
            partToUpdate.setName(partResource.getName());
            partToUpdate.setPrice(partResource.getPrice());
            partToUpdate.setQuantity(partResource.getQuantity());
            partToUpdate.setBikeShop(bikeShopRepository.getReferenceById(partResource.getBikeShopId()));

            return PART_MAPPER.toPartResource(partRepository.save(partToUpdate));
    }

    @Override
    public void delete(Long id) {
        partRepository.deleteById(id);
    }


}
