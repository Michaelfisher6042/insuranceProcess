package org.example.repository;

import org.example.domain.Client;
import org.example.domain.ContactMethodType;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ClientRepository {

    public static ConcurrentHashMap<String, Client> clients;

    ClientRepository() {
        clients = new ConcurrentHashMap<>();
    }

    public void addClient(String clientId, Client client) {
        clients.put(clientId, client);
    }

    public Optional<Client> getClientById(String clientId) {
        return Optional.ofNullable(clients.get(clientId));
    }

    public void updateClientById(String clientId, Client client) {
        clients.put(clientId, client);
    }

    public boolean existsByContactMethod(ContactMethodType methodType, String methodValue) {
        return clients.values().stream().anyMatch(
                client -> client.getContactMethod().getMethodType().equals(methodType)
                        && client.getContactMethod().getMethodValue().equals(methodValue));
    }
}
