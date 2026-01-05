package com.enterprise.catalog.isolation.database;

import com.enterprise.catalog.isolation.database.modele.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
    // Spring Data JPA automatically implements these methods!
    
    // Find products by category
    List<ProductEntity> findByCategory(String category);
    
    // Find products by name containing text (case insensitive)
    List<ProductEntity> findByNameContainingIgnoreCase(String name);
    
    // Find products with price greater than specified amount
    List<ProductEntity> findByPriceGreaterThan(java.math.BigDecimal price);
}