package com.qrcafe.qrcafeback.dto.registration;

import com.qrcafe.qrcafeback.enums.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class RegistrationOrderDto {
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private UUID restaurantId;
}
