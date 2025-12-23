package org.example.dto;

import lombok.Data;

@Data
public class UpdateProductRequestDto {
    public String clientId;
    public String productId;
    public String newName;
    public String status;
}
