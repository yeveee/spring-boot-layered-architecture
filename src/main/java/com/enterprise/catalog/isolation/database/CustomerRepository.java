package com.enterprise.catalog.isolation.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.catalog.isolation.database.modele.CustomerEntity;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{


    List<CustomerEntity> findByEmail(String email);
    List<CustomerEntity> findByStatus(String status);
    
}
