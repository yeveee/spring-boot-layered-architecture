package com.enterprise.catalog.isolation.database;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;


import com.enterprise.catalog.isolation.database.mappeur.OrderParametreAccesseurMapper;
import com.enterprise.catalog.isolation.database.mappeur.OrderReponseAccesseurMapper;
import com.enterprise.catalog.service.order.modele.Order;
@Component
public class OrderIsolationManager {
    
    private final OrderRepository orderRepository;
    private final OrderParametreAccesseurMapper parametreMapper;
    private final OrderReponseAccesseurMapper reponseMapper;

    public OrderIsolationManager(OrderRepository orderRepository,
                                   OrderParametreAccesseurMapper parametreMapper, 
                                   OrderReponseAccesseurMapper reponseMapper) {
        this.orderRepository = orderRepository;
        this.parametreMapper = parametreMapper;
        this.reponseMapper = reponseMapper;
    }

    public Order save(Order order) {

        var orderEntity = parametreMapper.map(order);

        var savedOrderEntity = orderRepository.save(orderEntity);

        return reponseMapper.map(savedOrderEntity);

    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id)
                .map(reponseMapper::map);  
    }

    public List<Order> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(reponseMapper::map)  // Convert each entity
                .toList();
    }

    public List<Order> findByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId)
                .stream()
                .map(reponseMapper::map)  // Convert each entity
                .toList();
    }

    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatus(status)
                .stream()
                .map(reponseMapper::map)
                .toList();
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

}
