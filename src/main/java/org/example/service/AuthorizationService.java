package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.ContactMethod;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorizationService {

    private final ClientRepository clientRepository;

    public boolean authenticate(String userId, String methodType , String contactValue) {
        var client = clientRepository.getClientById(userId);
        if (client.isEmpty()) {
            return false;
        }
        if(client.get().getContactMethod() != null){
            return client.get().getContactMethod().getMethodType().equalsIgnoreCase(methodType) &&
                    client.get().getContactMethod().getMethodValue().equalsIgnoreCase(contactValue);
        }
        return false;
    }

}
