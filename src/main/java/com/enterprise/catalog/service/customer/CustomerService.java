package com.enterprise.catalog.service.customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enterprise.catalog.isolation.database.CustomerIsolationManager;
import com.enterprise.catalog.service.customer.modele.Customer;

@Service
public class CustomerService {

    private final CustomerIsolationManager customerIsolationManager;

    public CustomerService(CustomerIsolationManager customerIsolationManager) {
        this.customerIsolationManager = customerIsolationManager;
    }
    
    public Customer saveCustomer(Customer customer) {
        
        validateCustomer(customer);
        
        return customerIsolationManager.save(customer);
    }

    private void validateCustomer(Customer customer) {
        if (customer.getEmail() == null) {
            throw new IllegalArgumentException("Customer email is required");
        }
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerIsolationManager.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerIsolationManager.findAll();
    }

    public void deleteCustomer(Long id) {
        
        if (customerIsolationManager.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }
        
        customerIsolationManager.deleteById(id);
    }

    public List<Customer> getCustomerByEmail(String email) {
        return customerIsolationManager.findByEmail(email);
    }

    public List<Customer> getVipCustomers() {
        return customerIsolationManager.findAll()
        .stream()
        .filter(Customer::isVip)
        .toList();
    }

    public boolean canCustomerRedeemPoints(Long customerId, int pointsToRedeem) {
        Optional<Customer> customerOpt = customerIsolationManager.findById(customerId);
        return customerOpt.map(customer -> customer.canRedeemPoints(pointsToRedeem))
        .orElse(false);
    }
    
}
