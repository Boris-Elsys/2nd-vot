package com.example.bikeshopapi.controller;


import com.example.bikeshopapi.controller.resources.SaleableBikeResource;
import com.example.bikeshopapi.service.SaleableBikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/saleable-bikes")
@RequiredArgsConstructor
public class SaleableBikeController {

    private final SaleableBikeService saleableBikeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(saleableBikeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(saleableBikeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SaleableBikeResource saleableBikeResource) {
        SaleableBikeResource saleableBike = saleableBikeService.save(saleableBikeResource);

        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/saleable-bikes/{id}").
                buildAndExpand(saleableBike.getId()).toUri()).body(saleableBike);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody SaleableBikeResource saleableBikeResource, @PathVariable Long id) {
        return ResponseEntity.ok(saleableBikeService.update(saleableBikeResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        saleableBikeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
