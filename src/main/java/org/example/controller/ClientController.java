package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;
import org.example.dto.ClientAuthRequest;
import org.example.dto.ClientWithProductsResponse;
import org.example.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Set<Product>> createNewClient(@RequestBody ClientAuthRequest clientAuthRequest) {
        return ResponseEntity.ok(clientService.createClient(clientAuthRequest));
    }

    @PostMapping("/existing")
    public ResponseEntity<java.util.List<ClientWithProductsResponse.ProductInfo>> existingClient(@RequestBody ClientAuthRequest request) {
        java.util.List<ClientWithProductsResponse.ProductInfo> products = clientService.authenticateAndGetClientProducts(request);
        return ResponseEntity.ok(products);
    }
}
