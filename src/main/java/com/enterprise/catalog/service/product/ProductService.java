package com.enterprise.catalog.service.product;

import com.enterprise.catalog.isolation.database.ProductIsolationManager;
import com.enterprise.catalog.isolation.rest.ReviewIsolationManager;
import com.enterprise.catalog.service.product.modele.Product;
import com.enterprise.catalog.service.product.modele.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductIsolationManager productIsolationManager;
    private final ReviewIsolationManager reviewIsolationManager;

    // Constructor injection
    public ProductService(ProductIsolationManager productIsolationManager,
                         ReviewIsolationManager reviewIsolationManager) {
        this.productIsolationManager = productIsolationManager;
        this.reviewIsolationManager = reviewIsolationManager;
    }

    // Business method: Save product with validation
    public Product saveProduct(Product product) {
        // Business validation
        validateProduct(product);
        
        // Save to database via isolation manager
        return productIsolationManager.save(product);
    }

    // Business method: Get product with reviews
    public Optional<Product> getProductWithReviews(Long productId) {
        // Get product from database
        Optional<Product> productOpt = productIsolationManager.findById(productId);
        
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            
            // Get reviews from external API
            List<Review> reviews = reviewIsolationManager.getReviewsForProduct(productId);
            
            // Business logic: Calculate average rating
            calculateAndSetAverageRating(product, reviews);
            
            return Optional.of(product);
        }
        
        return Optional.empty();
    }

    // Business method: Get all products
    public List<Product> getAllProducts() {
        return productIsolationManager.findAll();
    }

    // Business method: Get products by category
    public List<Product> getProductsByCategory(String category) {
        return productIsolationManager.findByCategory(category);
    }

    // Business method: Get expensive products
    public List<Product> getExpensiveProducts() {
        return productIsolationManager.findAll()
                .stream()
                .filter(Product::isExpensive)  // Use business method from Product
                .toList();
    }

    // Business method: Delete product
    public void deleteProduct(Long productId) {
        // Business validation: Check if product exists
        if (productIsolationManager.findById(productId).isEmpty()) {
            throw new IllegalArgumentException("Product not found with id: " + productId);
        }
        
        productIsolationManager.deleteById(productId);
    }

    // Private business validation method
    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required");
        }
        
        if (product.getPrice().isPresent() && 
            product.getPrice().get().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
    }

    // Private business logic method
    private void calculateAndSetAverageRating(Product product, List<Review> reviews) {
        if (reviews.isEmpty()) {
            return; // No reviews, no rating to calculate
        }
        
        // Calculate average rating from reviews
        double averageRating = reviews.stream()
                .filter(review -> review.getRating().isPresent())
                .mapToInt(review -> review.getRating().get())
                .average()
                .orElse(0.0);
        
        // You could add this to Product model or handle it differently
        // For now, just log it (in real app, might store it)
        System.out.println("Product " + product.getName() + " has average rating: " + averageRating);
    }
}