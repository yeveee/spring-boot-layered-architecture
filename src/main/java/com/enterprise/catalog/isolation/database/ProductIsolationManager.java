package com.enterprise.catalog.isolation.database;

import com.enterprise.catalog.isolation.database.mappeur.ProductParametreAccesseurMapper;
import com.enterprise.catalog.isolation.database.mappeur.ProductReponseAccesseurMapper;
import com.enterprise.catalog.service.product.modele.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductIsolationManager {

    private final ProductRepository repository;
    private final ProductParametreAccesseurMapper parametreMapper;
    private final ProductReponseAccesseurMapper reponseMapper;

    // Constructor injection (architecture requirement)
    public ProductIsolationManager(ProductRepository repository,
                                 ProductParametreAccesseurMapper parametreMapper,
                                 ProductReponseAccesseurMapper reponseMapper) {
        this.repository = repository;
        this.parametreMapper = parametreMapper;
        this.reponseMapper = reponseMapper;
    }

    public Product save(Product product) {
        // Convert: Product → ProductEntity
        var entity = parametreMapper.map(product);
        
        // Save to database
        var savedEntity = repository.save(entity);
        
        // Convert back: ProductEntity → Product
        return reponseMapper.map(savedEntity);
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id)
                .map(reponseMapper::map);  // Convert if found
    }

    public List<Product> findAll() {
        return repository.findAll()
                .stream()
                .map(reponseMapper::map)  // Convert each entity
                .toList();
    }

    public List<Product> findByCategory(String category) {
        return repository.findByCategory(category)
                .stream()
                .map(reponseMapper::map)
                .toList();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}