package com.enterprise.catalog.isolation.rest.modele;

import com.enterprise.catalog.noyau.modele.ModeleAccesseur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewAccesseur implements ModeleAccesseur {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("reviewerName")
    private String reviewerName;

    // Default constructor (required for JSON deserialization)
    public ReviewAccesseur() {
    }

    // Constructor with all fields
    public ReviewAccesseur(Long id, Long productId, Integer rating, String comment, String reviewerName) {
        this.id = id;
        this.productId = productId;
        this.rating = rating;
        this.comment = comment;
        this.reviewerName = reviewerName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
}