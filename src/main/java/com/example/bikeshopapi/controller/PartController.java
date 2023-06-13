package com.example.bikeshopapi.controller;

import com.example.bikeshopapi.controller.resources.PartResource;
import com.example.bikeshopapi.service.PartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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



}
