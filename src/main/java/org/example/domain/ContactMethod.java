package org.example.domain;

import lombok.Data;

@Data
public class ContactMethod {
    private String methodType; // EMAIL, PHONE, SMS
    private String methodValue;
}
