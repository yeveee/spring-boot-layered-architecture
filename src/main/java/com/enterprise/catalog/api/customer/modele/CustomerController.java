package com.enterprise.catalog.api.customer.modele;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.catalog.api.customer.mappeur.CustomerApiParametreMapper;
import com.enterprise.catalog.api.customer.mappeur.CustomerApiReponseMapper;
import com.enterprise.catalog.service.customer.CustomerService;
import com.enterprise.catalog.service.customer.modele.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/customers")
@Tag(name = "Customer Management", description = "Operation for managing customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerApiParametreMapper parametreMapper;
    private final CustomerApiReponseMapper reponseMapper;

    

    public CustomerController(CustomerService customerService, CustomerApiParametreMapper parametreMapper,
            CustomerApiReponseMapper reponseMapper) {
        this.customerService = customerService;
        this.parametreMapper = parametreMapper;
        this.reponseMapper = reponseMapper;
    }

    @GetMapping
    public ResponseEntity<List<CustomerApi>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<CustomerApi> customersApi = customers
        .stream()
        .map(reponseMapper::map)
        .toList();
        return ResponseEntity.ok(customersApi);
    }

    @PostMapping
    @Operation(summary = "Create new customer", description = "Create a new customer")
    public ResponseEntity<CustomerApi> createCustomer(@RequestBody CustomerApi customerApi) {
        try {
        Customer customer = parametreMapper.map(customerApi);
        Customer savedCustomer = customerService.saveCustomer(customer);
        CustomerApi reponseApi = reponseMapper.map(savedCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(reponseApi);
    } catch(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
}
    }}
