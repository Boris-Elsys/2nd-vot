package com.example.bikeshopapi.controller;

import com.example.bikeshopapi.controller.resources.PartResource;
import com.example.bikeshopapi.service.PartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/part")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;
    private final ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(partService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(partService.getById(id));
    }

    @GetMapping("/audit/{id}")
    public ResponseEntity<?> getAudit(@PathVariable Long id) {
        return ResponseEntity.ok(partService.getAudit(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PartResource partResource) {
        PartResource part = partService.save(partResource);

        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/part/{id}").
                buildAndExpand(part.getId()).toUri()).body(part);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PartResource partResource, @PathVariable Long id) {
        return ResponseEntity.ok(partService.update(partResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        partService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/monthly-sold")
    public ResponseEntity<Integer> monthlySold(@PathVariable Long id) {

        return ResponseEntity.ok(partService.monthlySold(id));
    }

    @GetMapping("/api/part/{id}/quantity-change")
    public ResponseEntity<Integer> quantityChange(@PathVariable Long id) {
        LocalDateTime startDate = LocalDateTime.now().minusMonths(1);
        LocalDateTime endDate = LocalDateTime.now();

        Date start = java.sql.Timestamp.valueOf(startDate);
        Date end = java.sql.Timestamp.valueOf(endDate);

        Integer quantityChange = partService.getQuantityChange(id, start, end);
        return ResponseEntity.ok(quantityChange);
    }



}
