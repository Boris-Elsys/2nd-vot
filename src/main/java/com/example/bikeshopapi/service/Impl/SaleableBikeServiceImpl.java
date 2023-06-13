package com.example.bikeshopapi.service.Impl;

import com.example.bikeshopapi.controller.resources.SaleableBikeResource;
import com.example.bikeshopapi.entity.SaleableBike;
import com.example.bikeshopapi.repository.SaleableBikeRepository;
import com.example.bikeshopapi.service.SaleableBikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.hibernate.envers.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

import static com.example.bikeshopapi.mapper.SaleableBikeMapper.SALEABLE_BIKE_MAPPER;

@Service
@RequiredArgsConstructor
public class SaleableBikeServiceImpl implements SaleableBikeService {

    private final SaleableBikeRepository saleableBikeRepository;

    @Override
    public SaleableBikeResource getById(Long id) {
        return SALEABLE_BIKE_MAPPER.toSaleableBikeResource(saleableBikeRepository.getReferenceById(id));
    }

    @Override
    public List<SaleableBikeResource> getAll() {
        return SALEABLE_BIKE_MAPPER.toSaleableBikeResources(saleableBikeRepository.findAll());
    }

    @Override
    public List<SaleableBikeResource> getAudit(Long id){

        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        List<Number> revisions = auditReader.getRevisions(SaleableBike.class, id);
        List<SaleableBike> saleableBikes = new ArrayList<>();
        for (Number revision : revisions) {
            SaleableBike saleableBike = auditReader.find(SaleableBike.class, id, revision);
            saleableBikes.add(saleableBike);
        }
        return SALEABLE_BIKE_MAPPER.toSaleableBikeResources(saleableBikes);

    }

    @Override
    public SaleableBikeResource save(SaleableBikeResource saleableBikeResource) {

        SaleableBike saleableBikeToSave = SALEABLE_BIKE_MAPPER.fromSaleableBikeResource(saleableBikeResource);
        saleableBikeToSave.setBikeShop(saleableBikeToSave.getBikeShop());
        saleableBikeToSave.setPrice(saleableBikeToSave.getPrice());
        saleableBikeToSave.setBrand(saleableBikeToSave.getBrand());
        saleableBikeToSave.setModel(saleableBikeToSave.getModel());
        saleableBikeToSave.setColor(saleableBikeToSave.getColor());
        saleableBikeToSave.setSize(saleableBikeToSave.getSize());
        saleableBikeToSave.setType(saleableBikeToSave.getType());
        saleableBikeToSave.setFrame(saleableBikeToSave.getFrame());
        saleableBikeToSave.setFork(saleableBikeToSave.getFork());
        saleableBikeToSave.setShock(saleableBikeToSave.getShock());
        saleableBikeToSave.setCreated(saleableBikeToSave.getCreated());
        saleableBikeToSave.setLastModified(saleableBikeToSave.getLastModified());

        return SALEABLE_BIKE_MAPPER.toSaleableBikeResource(saleableBikeRepository.save(saleableBikeToSave));
    }

    @Override
    public SaleableBikeResource update(SaleableBikeResource saleableBikeResource, Long id) {

        SaleableBikeResource saleableBikeToUpdate = getById(id);
        saleableBikeToUpdate.setId(saleableBikeToUpdate.getId());
        saleableBikeToUpdate.setBikeShopId(saleableBikeToUpdate.getBikeShopId());
        saleableBikeToUpdate.setBrand(saleableBikeToUpdate.getBrand());
        saleableBikeToUpdate.setModel(saleableBikeToUpdate.getModel());
        saleableBikeToUpdate.setColor(saleableBikeToUpdate.getColor());
        saleableBikeToUpdate.setSize(saleableBikeToUpdate.getSize());
        saleableBikeToUpdate.setType(saleableBikeToUpdate.getType());
        saleableBikeToUpdate.setFrame(saleableBikeToUpdate.getFrame());
        saleableBikeToUpdate.setFork(saleableBikeToUpdate.getFork());
        saleableBikeToUpdate.setShock(saleableBikeToUpdate.getShock());
        saleableBikeToUpdate.setPrice(saleableBikeToUpdate.getPrice());
        saleableBikeToUpdate.setCreated(saleableBikeToUpdate.getCreated());
        saleableBikeToUpdate.setLastModified(saleableBikeToUpdate.getLastModified());

        return SALEABLE_BIKE_MAPPER.toSaleableBikeResource(saleableBikeRepository.save(SALEABLE_BIKE_MAPPER.fromSaleableBikeResource(saleableBikeResource)));

    }

    @Override
    public void delete(Long id) {
        saleableBikeRepository.deleteById(id);
    }

}
