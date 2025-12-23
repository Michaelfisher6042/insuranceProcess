package org.example.repository;

import org.example.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class ClientRepository {

    public static HashMap<String, Client> clients;

    ClientRepository() {
        clients = new HashMap<>();
    }

    public void addClient(String clientId, Client client) {
        clients.put(clientId, client);
    }

    public Optional<Client> getClientById(String clientId) {
        return Optional.ofNullable(clients.get(clientId));
    }

    public Client deleteClientById(String clientId) {
        return clients.remove(clientId);
    }

    public Client updateClientById(String clientId, Client client) {
        clients.put(clientId, client);
        return client;
    }

    public boolean existsByContactMethod(String methodType, String methodValue) {
        return clients.values().stream().anyMatch(
                client -> client.getContactMethod().getMethodType().equals(methodType)
                        && client.getContactMethod().getMethodValue().equals(methodValue));
    }
}
