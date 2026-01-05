package com.enterprise.catalog.api.product.modele;

import com.enterprise.catalog.noyau.modele.ModeleApi;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product information for API")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductApi implements ModeleApi {

    @Schema(description = "Product unique identifier", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "Product name", example = "iPhone 15", required = true)
    @JsonProperty("name")
    private String name;

    @Schema(description = "Product description", example = "Latest iPhone model")
    @JsonProperty("description")
    private String description;

    @Schema(description = "Product price in euros", example = "999.99")
    @JsonProperty("price")
    private String price;  // Notice: String for API (user input validation)

    @Schema(description = "Product category", example = "Electronics")
    @JsonProperty("category")
    private String category;

    // Default constructor (required for JSON deserialization)
    public ProductApi() {
    }

    // Constructor with all fields
    public ProductApi(Long id, String name, String description, String price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}