package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.domain.Client;
import org.example.domain.ClientProduct;
import org.example.domain.Product;
import org.example.domain.ProductStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class ClientProductService {

    private final ClientService clientService;
    private final ProductService productService;

    public ClientProduct assignProductToClient(String clientId, String productId) {
        Client client = clientService.getClientById(clientId);
        Product product = productService.getProductById(productId);

        boolean alreadyExists = client.getClientProducts().stream()
                .anyMatch(cp -> cp.getProduct().getId().equals(productId));

        if (alreadyExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client already has this product");
        }

        ClientProduct clientProduct = new ClientProduct();
        clientProduct.setProduct(product);
        if (client.getClientProducts().isEmpty()) {
            client.setClientProducts(new java.util.ArrayList<>());
        }
        clientProduct.setStatus(ProductStatus.ACTIVE);
        client.getClientProducts().add(clientProduct);
        clientService.update(client);
        return clientProduct;
    }


    public void updateProductStatus(String clientId, String productId, ProductStatus newStatus) {
        Client client = clientService.getClientById(clientId);
        ClientProduct clientProduct = client.getClientProducts().stream()
                .filter(cp -> cp.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found for this client"));
        clientProduct.setStatus(newStatus);
        clientService.update(client);
    }

}
