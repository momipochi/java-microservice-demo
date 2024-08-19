package com.example.products.products.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.products.model.Product;

public interface ProductsRepository extends JpaRepository<Product, UUID> {
    
}
