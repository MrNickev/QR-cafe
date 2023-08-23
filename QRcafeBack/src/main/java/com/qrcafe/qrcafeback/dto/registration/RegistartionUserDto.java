package com.qrcafe.qrcafeback.dto.registration;

import com.qrcafe.qrcafeback.enums.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class RegistartionUserDto {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;
    private String email;
}
