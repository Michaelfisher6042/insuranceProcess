package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.domain.ContactMethod;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientWithProductsResponse {
    private String clientId;
    private String name;
    private ContactMethod contactMethod;
    private LocalDateTime createdAt;
    private List<ProductInfo> products;

    @Data
    public static class ProductInfo {
        private String productId;
        private String productName;
        private String productDescription;
        private LocalDateTime updateTime;
        private String status;

        public ProductInfo(String id, String name, String description, String status) {
            this.productId = id;
            this.productName = name;
            this.productDescription = description;
            this.updateTime = LocalDateTime.now();
            this.status = status;
        }
    }
}