package org.example.repository;

import org.example.domain.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

@Repository
public class ProductRepository {
    public static HashMap<String, Product> products;

    ProductRepository() {
        initializeProducts();
    }

    public static HashMap<String, Product> initializeProducts() {
        products = new HashMap<>();
        products.put("P001", new Product("P001", "policy-a", BigDecimal.valueOf(6.55), "Car insurance"));
        products.put("P002", new Product("P002", "policy-b", BigDecimal.valueOf(7.55), "pension plan"));
        products.put("P003", new Product("P003", "policy-c", BigDecimal.valueOf(8.55), "health insurance"));
        return products;
    }

    public Optional<Product> getProductById(String productId) {
        return Optional.of(products.get(productId));
    }

}
