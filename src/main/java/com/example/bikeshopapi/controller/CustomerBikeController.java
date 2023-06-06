package com.example.bikeshopapi.controller;

import com.example.bikeshopapi.controller.resources.CustomerBikeResource;
import com.example.bikeshopapi.service.CustomerBikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/customer-bike")
@RequiredArgsConstructor
public class CustomerBikeController {

    private final CustomerBikeService customerBikeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(customerBikeService.getAll());
    }

    @GetMapping("/id")
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok(customerBikeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerBikeResource customerBikeResource) {
        CustomerBikeResource customerBike = customerBikeService.save(customerBikeResource);

        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/customer-bike/{id}").
                buildAndExpand(customerBike.getId()).toUri()).body(customerBike);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CustomerBikeResource customerBikeResource, @PathVariable Long id) {
        return ResponseEntity.ok(customerBikeService.update(customerBikeResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        customerBikeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
