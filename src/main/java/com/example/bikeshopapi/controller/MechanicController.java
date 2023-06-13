package com.example.bikeshopapi.controller;

import com.example.bikeshopapi.controller.resources.MechanicResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bikeshopapi.service.MechanicService;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/mechanic")
@RequiredArgsConstructor
public class MechanicController {

    private final MechanicService mechanicService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(mechanicService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mechanicService.getById(id));
    }

    @GetMapping("/audit/{id}")
    public ResponseEntity<?> getAudit(@PathVariable Long id) {
        return ResponseEntity.ok(mechanicService.getAudit(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MechanicResource mechanicResource) {
        MechanicResource mechanic = mechanicService.save(mechanicResource);

        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/mechanic/{id}").
                buildAndExpand(mechanic.getId()).toUri()).body(mechanic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody MechanicResource mechanicResource, @PathVariable Long id) {
        return ResponseEntity.ok(mechanicService.update(mechanicResource, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        mechanicService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
