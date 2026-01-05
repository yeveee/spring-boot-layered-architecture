package com.enterprise.catalog.service.product.modele;

import com.enterprise.catalog.noyau.modele.ModeleInterne;

import java.math.BigDecimal;
import java.util.Optional;

public class Product implements ModeleInterne {

    private Optional<Long> id;
    private String name;  // Required field - no Optional needed
    private Optional<String> description;
    private Optional<BigDecimal> price;  // Notice: BigDecimal for business calculations
    private Optional<String> category;

    // Default constructor
    public Product() {
        this.id = Optional.empty();
        this.description = Optional.empty();
        this.price = Optional.empty();
        this.category = Optional.empty();
    }

    // Constructor with required fields
    public Product(String name) {
        this();
        this.name = name;
    }

    // Constructor with all fields
    public Product(Optional<Long> id, String name, Optional<String> description, 
                   Optional<BigDecimal> price, Optional<String> category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Business Methods (this is what makes it a business model!)
    public boolean isExpensive() {
        return price.map(p -> p.compareTo(new BigDecimal("100")) > 0)
                   .orElse(false);
    }

    public Optional<BigDecimal> calculateDiscountPrice(BigDecimal discountPercentage) {
        return price.map(p -> {
            BigDecimal discount = p.multiply(discountPercentage).divide(new BigDecimal("100"));
            return p.subtract(discount);
        });
    }

    public boolean hasDescription() {
        return description.isPresent() && !description.get().trim().isEmpty();
    }

    // Getters and Setters
    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public void setDescription(Optional<String> description) {
        this.description = description;
    }

    public Optional<BigDecimal> getPrice() {
        return price;
    }

    public void setPrice(Optional<BigDecimal> price) {
        this.price = price;
    }

    public Optional<String> getCategory() {
        return category;
    }

    public void setCategory(Optional<String> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}