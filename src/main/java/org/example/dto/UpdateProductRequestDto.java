package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.domain.ProductStatus;

@Data
public class UpdateProductRequestDto {
    @NotBlank
    private String clientId;
    @NotBlank
    private String productId;
    private ProductStatus status;
}
