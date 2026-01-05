package com.enterprise.catalog.api.customer.modele;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/customers")
@Tag(name = "Customer Management", description = "Operation for managing customers")
public class CustomerController {

    @GetMapping
    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers")
    public ResponseEntity<List<CustomerApi>> getAllCustomers() {
        // TODO: Implement when we have the service layer
        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    @Operation(summary = "Create new customer", description = "Create a new customer")
    public ResponseEntity<CustomerApi> createCustomer(@RequestBody CustomerApi customerApi) {
        //TODO: Implement when we have the service layer
        return ResponseEntity.ok(customerApi);
    }
}
