package org.example.domain;

import lombok.Data;

@Data
public class ClientProduct {
    private Product product;
    private String productId;
    private String productName;
    private ProductStatus status;

}
