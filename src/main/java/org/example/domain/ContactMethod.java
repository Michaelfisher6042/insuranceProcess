package org.example.domain;

import lombok.Data;

@Data
public class ContactMethod {
    private ContactMethodType methodType; // EMAIL, PHONE, SMS
    private String methodValue;
}
