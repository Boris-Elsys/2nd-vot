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


import java.util.Date;
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

    @Override
    public Integer monthlySold(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(Part.class, id);
        List<Part> parts = new ArrayList<>();
        for (Number revision : revisions) {
            Part part = auditReader.find(Part.class, id, revision);
            parts.add(part);
        }

        // Compare the quantity of parts at the beginning of the month to the current quantity
        // If there is a difference, return it in JSON format
        // Otherwise, return 0 to indicate no change
        if (parts.size() >= 2) {
            Part currentPart = parts.get(parts.size() - 1);
            Part previousPart = parts.get(parts.size() - 2);
            int quantityDifference = currentPart.getQuantity() - previousPart.getQuantity();
            return Math.abs(quantityDifference);
        } else {
            return 0;
        }
    }

    @Override
    public Integer getQuantityChange(Long id, Date start, Date end) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager.createEntityManager());

        // Retrieve the list of revisions for the specified part
        List<Number> revisions = auditReader.getRevisions(Part.class, id);

        List<Part> parts = new ArrayList<>();
        for (Number revision : revisions) {
            Part part = auditReader.find(Part.class, id, revision);
            Date revisionDate = part.getLastModified(); // Assuming lastModified represents the revision date
            if (revisionDate.after(start) && revisionDate.before(end)) {
                parts.add(part);
            }
        }

        // Calculate the total change in quantity by comparing the first and last revisions
        if (!parts.isEmpty()) {
            Part firstPart = parts.get(0);
            Part lastPart = parts.get(parts.size() - 1);
            int quantityChange = lastPart.getQuantity() - firstPart.getQuantity();
            return quantityChange;
        } else {
            return 0;
        }
    }

}