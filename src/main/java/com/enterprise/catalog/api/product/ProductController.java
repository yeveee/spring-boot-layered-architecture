package com.enterprise.catalog.api.product;

import com.enterprise.catalog.api.product.mappeur.ProductApiParametreMapper;
import com.enterprise.catalog.api.product.mappeur.ProductApiReponseMapper;
import com.enterprise.catalog.api.product.modele.ProductApi;
import com.enterprise.catalog.service.product.ProductService;
import com.enterprise.catalog.service.product.modele.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product Management", description = "Operations for managing products")
public class ProductController {

    private final ProductService productService;
    private final ProductApiParametreMapper parametreMapper;
    private final ProductApiReponseMapper reponseMapper;

    // Constructor injection
    public ProductController(ProductService productService,
                           ProductApiParametreMapper parametreMapper,
                           ProductApiReponseMapper reponseMapper) {
        this.productService = productService;
        this.parametreMapper = parametreMapper;
        this.reponseMapper = reponseMapper;
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieve a list of all products")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    public ResponseEntity<List<ProductApi>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        
        List<ProductApi> productApis = products.stream()
                .map(reponseMapper::map)  // Product → ProductApi
                .toList();
        
        return ResponseEntity.ok(productApis);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieve a specific product with its reviews")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<ProductApi> getProductById(
            @Parameter(description = "Product ID") @PathVariable Long id) {
        
        Optional<Product> productOpt = productService.getProductWithReviews(id);
        
        if (productOpt.isPresent()) {
            ProductApi productApi = reponseMapper.map(productOpt.get());
            return ResponseEntity.ok(productApi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Create new product", description = "Create a new product")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Product created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid product data")
    })
    public ResponseEntity<ProductApi> createProduct(@RequestBody ProductApi productApi) {
        try {
            // Convert: ProductApi → Product
            Product product = parametreMapper.map(productApi);
            
            // Business logic
            Product savedProduct = productService.saveProduct(product);
            
            // Convert back: Product → ProductApi
            ProductApi responseApi = reponseMapper.map(savedProduct);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(responseApi);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Get products by category", description = "Retrieve products filtered by category")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    public ResponseEntity<List<ProductApi>> getProductsByCategory(
            @Parameter(description = "Product category") @PathVariable String category) {
        
        List<Product> products = productService.getProductsByCategory(category);
        
        List<ProductApi> productApis = products.stream()
                .map(reponseMapper::map)
                .toList();
        
        return ResponseEntity.ok(productApis);
    }

    @GetMapping("/expensive")
    @Operation(summary = "Get expensive products", description = "Retrieve products that are considered expensive")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved expensive products")
    public ResponseEntity<List<ProductApi>> getExpensiveProducts() {
        List<Product> products = productService.getExpensiveProducts();
        
        List<ProductApi> productApis = products.stream()
                .map(reponseMapper::map)
                .toList();
        
        return ResponseEntity.ok(productApis);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product", description = "Delete a product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "Product ID") @PathVariable Long id) {
        
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}