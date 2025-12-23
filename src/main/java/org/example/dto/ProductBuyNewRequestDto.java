package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.domain.ContactMethod;

@Data
public class ProductBuyNewRequestDto {
    @NotBlank
    private String clientId;
    @NotBlank
    private String productId;
    @NotNull
    private ContactMethod contactMethod;
}
