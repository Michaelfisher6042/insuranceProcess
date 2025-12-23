package org.example.dto;

import lombok.Data;
import org.example.domain.ContactMethod;

@Data
public class ClientAuthRequest {
    private String id;
    private ContactMethod contactMethod;
}
