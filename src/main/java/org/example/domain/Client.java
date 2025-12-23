package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class Client {
    private String id;
    private String name;
    private ContactMethod contactMethod;
    private List<ClientProduct> clientProducts = new ArrayList<>();

    public Client(String clientId, ContactMethod contactMethod, List<ClientProduct> clientProducts) {
        this.id = clientId;
        this.contactMethod = contactMethod;
        this.clientProducts = clientProducts;
    }
}
