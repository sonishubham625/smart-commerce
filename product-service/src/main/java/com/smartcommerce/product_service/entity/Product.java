package com.smartcommerce.product_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity 
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String category;

    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Product() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

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
public void setDescription(String description){
    this.description = description;
}

public BigDecimal getPrice(){
return price;
}
public String getCategory(){
    return category;

} 

public Integer getStock(){
return stock;
}

public LocalDateTime getCreatedAt(){
    return createdAt;
} 

public LocalDateTime getUpdatedAt(){
    return updatedAt;
} 

public void setPrice(BigDecimal price){
    this.price = price;
}
public void setCategory(String category){
    this.category = category;

} 

public void setStock( Integer stock){
this.stock = stock;
}

public void setCreatedAt(LocalDateTime createdAt){
    this.createdAt = createdAt;
} 

public void setUpdatedAt(LocalDateTime updatedAt){
    this.updatedAt = updatedAt;
} 
}
