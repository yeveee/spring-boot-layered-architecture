package com.enterprise.catalog.isolation.database;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.enterprise.catalog.isolation.database.mappeur.CustomerParametreAccesseurMapper;
import com.enterprise.catalog.isolation.database.mappeur.CustomerReponseAccesseurMapper;
import com.enterprise.catalog.service.customer.modele.Customer;
import com.enterprise.catalog.service.product.modele.Product;

@Component
public class CustomerIsolationManager {

    private final CustomerRepository customerRepository;
    private final CustomerParametreAccesseurMapper parametreMapper;
    private final CustomerReponseAccesseurMapper reponseMapper;
    
    public CustomerIsolationManager(CustomerRepository customerRepository,
                                   CustomerParametreAccesseurMapper parametreMapper, 
                                   CustomerReponseAccesseurMapper reponseMapper) {
        this.customerRepository = customerRepository;
        this.parametreMapper = parametreMapper;
        this.reponseMapper = reponseMapper;
    }

    public Customer save(Customer customer) {

        var customerEntity = parametreMapper.map(customer);

        var savedCustomerEntity = customerRepository.save(customerEntity);

        return reponseMapper.map(savedCustomerEntity);

    }

    
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id)
                .map(reponseMapper::map);  
    }

    public List<Customer> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(reponseMapper::map)  // Convert each entity
                .toList();
    }

    public List<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email)
                .stream()
                .map(reponseMapper::map)
                .toList();
    }

    public List<Customer> findByStatus(String status) {
        return customerRepository.findByStatus(status)
                .stream()
                .map(reponseMapper::map)
                .toList();
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
