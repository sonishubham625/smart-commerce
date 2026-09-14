package com.smartcommerce.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcommerce.product_service.entity.Product;
import com.smartcommerce.product_service.exception.ProductNotFoundException;
import com.smartcommerce.product_service.repository.ProductRepository;

@Service 
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(Product product) {
    return productRepository.save(product);
}
public List<Product> getAllProducts() {
    return productRepository.findAll();
}

public Product getProductById(Long id) {
    return productRepository.findById(id)
           .orElseThrow(() -> new ProductNotFoundException(
        "Product not found with id: " + id));
}
public Product updateProduct(Long id, Product productDetails) {

    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(
                    "Product not found with id: " + id
            ));

    product.setName(productDetails.getName());
    product.setDescription(productDetails.getDescription());
    product.setPrice(productDetails.getPrice());
    product.setCategory(productDetails.getCategory());
    product.setStock(productDetails.getStock());

    return productRepository.save(product);
}
public void deleteProduct(Long id) {

    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(
                    "Product not found with id: " + id
            ));

    productRepository.delete(product);
}

}
