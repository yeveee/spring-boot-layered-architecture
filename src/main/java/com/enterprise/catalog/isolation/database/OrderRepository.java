package com.enterprise.catalog.isolation.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.catalog.isolation.database.modele.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

    List<OrderEntity> findByCustomerId(Long customerId);
    List<OrderEntity> findByStatus(String status);
    
}
