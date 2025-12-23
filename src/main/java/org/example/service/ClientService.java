package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Client;
import org.example.domain.Product;
import org.example.dto.ClientAuthRequest;
import org.example.dto.ClientWithProductsResponse;
import org.example.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final AuthorizationService authorizationService;
    private final ClientRepository clientRepository;


    public Set<Product> createClient(ClientAuthRequest clientRequest) {
        if (clientRepository.existsByContactMethod(
                clientRequest.getContactMethod().getMethodType(),
                clientRequest.getContactMethod().getMethodValue())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact method already exists");
        }
        Client client = new Client(clientRequest.getId(),
                clientRequest.getContactMethod(),
                List.of()
        );

        clientRepository.addClient(clientRequest.getId(), client);
        return Set.of();
    }

    public Client getClientById(String id) {
        return clientRepository.getClientById(id)
                .orElseThrow(() -> new RuntimeException("Client %s not found: " + id));
    }

    public void update(Client client) {
        clientRepository.updateClientById(client.getId(), client);
    }

    public java.util.List<ClientWithProductsResponse.ProductInfo> authenticateAndGetClientProducts(ClientAuthRequest request) {
        if (!isAuthorized(request)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization failed for client: " + request.getId());

        }
        Client client = getClientById(request.getId());
        return client.getClientProducts().stream()
                .map(cp -> new ClientWithProductsResponse.ProductInfo(
                        cp.getProduct().getId(),
                        cp.getProduct().getName(),
                        cp.getProduct().getDescription(),
                        cp.getStatus()))
                .collect(Collectors.toList());
    }

    private boolean isAuthorized(ClientAuthRequest clientAuthRequest) {
        return authorizationService.authenticate(
                clientAuthRequest.getId(),
                clientAuthRequest.getContactMethod().getMethodType(),
                clientAuthRequest.getContactMethod().getMethodValue()
        );
    }
}
