package com.smartcommerce.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcommerce.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
