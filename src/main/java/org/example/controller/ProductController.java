package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProductBuyNewRequestDto;
import org.example.dto.UpdateProductRequestDto;
import org.example.service.ClientProductService;
import org.example.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ClientProductService clientProductService;
    private final ProductService productService;

    @PostMapping("/buy")
    public ResponseEntity<String> buyProduct(@RequestBody ProductBuyNewRequestDto request) {
        clientProductService.assignProductToClient(request.getClientId(), request.getProductId());
        return ResponseEntity.ok("Product purchased successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody UpdateProductRequestDto request) {
        clientProductService.updateProductStatus(
                request.getClientId(),
                request.getProductId(),
                request.getStatus()
        );
        return ResponseEntity.ok("Product status updated successfully");
    }
}
