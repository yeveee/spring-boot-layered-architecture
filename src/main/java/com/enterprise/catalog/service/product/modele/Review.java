package com.enterprise.catalog.service.product.modele;

import com.enterprise.catalog.noyau.modele.ModeleInterne;

import java.util.Optional;

public class Review implements ModeleInterne {

    private Optional<Long> id;
    private Optional<Long> productId;
    private Optional<Integer> rating;
    private Optional<String> comment;
    private Optional<String> reviewerName;

    // Default constructor
    public Review() {
        this.id = Optional.empty();
        this.productId = Optional.empty();
        this.rating = Optional.empty();
        this.comment = Optional.empty();
        this.reviewerName = Optional.empty();
    }

    // Constructor with all fields
    public Review(Optional<Long> id, Optional<Long> productId, Optional<Integer> rating, 
                  Optional<String> comment, Optional<String> reviewerName) {
        this.id = id;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
        this.reviewerName = reviewerName;
    }

    // Business methods
    public boolean isPositive() {
        return rating.map(r -> r >= 4).orElse(false);
    }

    public boolean hasComment() {
        return comment.isPresent() && !comment.get().trim().isEmpty();
    }

    public String getDisplayRating() {
        return rating.map(r -> "★".repeat(r) + "☆".repeat(5 - r))
                    .orElse("No rating");
    }

    // Getters and Setters
    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }

    public Optional<Long> getProductId() {
        return productId;
    }

    public void setProductId(Optional<Long> productId) {
        this.productId = productId;
    }

    public Optional<Integer> getRating() {
        return rating;
    }

    public void setRating(Optional<Integer> rating) {
        this.rating = rating;
    }

    public Optional<String> getComment() {
        return comment;
    }

    public void setComment(Optional<String> comment) {
        this.comment = comment;
    }

    public Optional<String> getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(Optional<String> reviewerName) {
        this.reviewerName = reviewerName;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", productId=" + productId +
                ", rating=" + rating +
                ", comment=" + comment +
                ", reviewerName=" + reviewerName +
                '}';
    }
}