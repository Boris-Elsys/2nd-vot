package com.example.bikeshopapi.controller;

import com.example.bikeshopapi.controller.resources.CustomerResource;
import com.example.bikeshopapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/id")
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerResource customerResource) {
        CustomerResource customer = customerService.save(customerResource);

        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/customer/{id}").
                buildAndExpand(customer.getId()).toUri()).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CustomerResource customerResource, @PathVariable Long id) {
        return ResponseEntity.ok(customerService.update(customerResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
