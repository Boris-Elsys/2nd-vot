package com.example.bikeshopapi.controller;

import com.example.bikeshopapi.controller.resources.BikeShopResource;
import com.example.bikeshopapi.service.BikeShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/bike-shop")
@RequiredArgsConstructor
public class BikeShopController {

    private final BikeShopService bikeShopService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(bikeShopService.getAll());
    }

    @GetMapping("/id")
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok(bikeShopService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BikeShopResource bikeShopResource) {
        BikeShopResource bikeShop = bikeShopService.save(bikeShopResource);

        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/bike-shop/{id}").
                buildAndExpand(bikeShop.getId()).toUri()).body(bikeShop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(BikeShopResource bikeShopResource, Long id) {
        return ResponseEntity.ok(bikeShopService.update(bikeShopResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bikeShopService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
