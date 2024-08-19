package com.example.products.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.products.model.Product;
import com.example.products.products.repository.ProductsRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }
}
