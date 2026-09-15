package com.smartcommerce.product_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcommerce.product_service.dto.ProductRequest;
import com.smartcommerce.product_service.dto.ProductResponse;
import com.smartcommerce.product_service.service.ProductService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;

}

@PostMapping
public ProductResponse createProduct(@Valid @RequestBody ProductRequest request) {
    return productService.createProduct(request);
}
@GetMapping
public List<ProductResponse> getAllProducts() {
    return productService.getAllProducts();
}

@GetMapping("/{id}")
public ProductResponse getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
}

@PutMapping("/{id}")
public ProductResponse updateProduct(
        @PathVariable Long id,
        @Valid @RequestBody ProductRequest request) {

    return productService.updateProduct(id, request);
}
@DeleteMapping("/{id}")
public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
}

}


