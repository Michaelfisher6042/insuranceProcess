package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProductById(String id) {
        return productRepository.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

}
