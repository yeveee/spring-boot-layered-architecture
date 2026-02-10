package com.enterprise.catalog.service.order;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enterprise.catalog.isolation.database.OrderIsolationManager;

import com.enterprise.catalog.service.order.modele.Order;

@Service
public class OrderService {
    
    private final OrderIsolationManager orderIsolationManager;

    public OrderService(OrderIsolationManager orderIsolationManager) {
        this.orderIsolationManager = orderIsolationManager;
    }

    public Order saveOrder(Order order) {
        
        validateOrder(order);
        
        return orderIsolationManager.save(order);
    }

    private void validateOrder(Order order) {
        if (order.getCustomerId() == null || order.getStatus().isEmpty()){
            throw new IllegalArgumentException("Customer id is required and should not be empty");
        }
    }

    public Optional<Order> getOrderById(Long id) {
        return orderIsolationManager.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderIsolationManager.findAll();
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderIsolationManager.findByCustomerId(customerId);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderIsolationManager.findByStatus(status);
    }

    public void deleteOrder(Long id) {
        
        if (orderIsolationManager.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Order not found with id: " + id);
        }
        
        orderIsolationManager.deleteById(id);
    }

    public List<Order> getExpensiveOrders() {
        return orderIsolationManager.findAll()
        .stream()
        .filter(Order::isExpensive)
        .toList();
    }

    public List<Order> getCancelableOrders() {
        return orderIsolationManager.findAll()
        .stream()
        .filter(Order::canBeCanceled)
        .toList();
    }
}
