package com.qrcafe.qrcafeback.entities;

import com.qrcafe.qrcafeback.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class RegistrationOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    private Restaurant restaurant;
}
