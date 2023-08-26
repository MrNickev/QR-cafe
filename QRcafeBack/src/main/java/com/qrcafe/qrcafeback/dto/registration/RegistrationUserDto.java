package com.qrcafe.qrcafeback.dto.registration;

import lombok.Data;

import java.util.UUID;

@Data
public class RegistrationUserDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private UUID registrationOrderId;
}
