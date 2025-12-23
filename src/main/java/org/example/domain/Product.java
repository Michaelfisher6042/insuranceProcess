package org.example.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Product {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private String category;
    private String description;

    // full constructor including id
    public Product(String id, String name, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

}
