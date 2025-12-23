package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.domain.ContactMethod;

@Data
public class ClientAuthRequest {
    @NotBlank
    private String id;
    @NotNull
    private ContactMethod contactMethod;
}
