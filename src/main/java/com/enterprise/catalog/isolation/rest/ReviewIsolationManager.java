package com.enterprise.catalog.isolation.rest;

import com.enterprise.catalog.isolation.rest.mappeur.ReviewReponseAccesseurMapper;
import com.enterprise.catalog.service.product.modele.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewIsolationManager {

    private final ReviewRestClient restClient;
    private final ReviewReponseAccesseurMapper reponseMapper;

    // Constructor injection
    public ReviewIsolationManager(ReviewRestClient restClient,
                                ReviewReponseAccesseurMapper reponseMapper) {
        this.restClient = restClient;
        this.reponseMapper = reponseMapper;
    }

    public List<Review> getReviewsForProduct(Long productId) {
        try {
            // Step 1: Call external API
            var reviewAccesseurs = restClient.getReviewsForProduct(productId);
            
            // Step 2: Convert to internal models
            return reviewAccesseurs.stream()
                    .map(reponseMapper::map)
                    .toList();
        } catch (Exception e) {
            // Log error and return empty list
            System.err.println("Failed to fetch reviews for product " + productId + ": " + e.getMessage());
            return List.of();
        }
    }
}