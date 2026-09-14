package com.smartcommerce.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcommerce.product_service.dto.ProductRequest;
import com.smartcommerce.product_service.dto.ProductResponse;
import com.smartcommerce.product_service.entity.Product;
import com.smartcommerce.product_service.exception.ProductNotFoundException;
import com.smartcommerce.product_service.repository.ProductRepository;

@Service 
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setStock(request.getStock());
    Product savedProduct = productRepository.save(product);

    return mapToResponse(savedProduct);
}
private ProductResponse mapToResponse(Product product) {

    ProductResponse response = new ProductResponse();

    response.setId(product.getId());
    response.setName(product.getName());
    response.setDescription(product.getDescription());
    response.setPrice(product.getPrice());
    response.setCategory(product.getCategory());
    response.setStock(product.getStock());
    response.setCreatedAt(product.getCreatedAt());
    response.setUpdatedAt(product.getUpdatedAt());

    return response;
}
public List<ProductResponse> getAllProducts() {

    return productRepository.findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
}

public ProductResponse getProductById(Long id) {

    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(
                    "Product not found with id: " + id
            ));

    return mapToResponse(product);
}
public ProductResponse updateProduct(Long id, ProductRequest request) {

    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(
                    "Product not found with id: " + id
            ));

    product.setName(request.getName());
    product.setDescription(request.getDescription());
    product.setPrice(request.getPrice());
    product.setCategory(request.getCategory());
    product.setStock(request.getStock());

    Product updatedProduct = productRepository.save(product);

    return mapToResponse(updatedProduct);
}
public void deleteProduct(Long id) {

    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(
                    "Product not found with id: " + id
            ));

    productRepository.delete(product);
}

}
