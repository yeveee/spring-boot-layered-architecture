package com.enterprise.catalog.isolation.rest;

import com.enterprise.catalog.isolation.rest.modele.ReviewAccesseur;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class ReviewRestClient {

    private final WebClient webClient;

    public ReviewRestClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com") // Mock API for demo
                .build();
    }

    public List<ReviewAccesseur> getReviewsForProduct(Long productId) {
        try {
            // Simulate external API call
            // In real world, this would call actual review service
            return webClient.get()
                    .uri("/comments?postId={productId}", productId)
                    .retrieve()
                    .bodyToFlux(ReviewAccesseur.class)
                    .collectList()
                    .block();
        } catch (Exception e) {
            // Handle API errors gracefully
            return List.of(); // Return empty list on error
        }
    }
}