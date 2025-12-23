package org.example.dto;

import lombok.Data;
import org.example.domain.ContactMethod;

@Data
public class ProductBuyNewRequestDto {
    public String clientId;
    public String productId;
    public ContactMethod contactMethod;
}
