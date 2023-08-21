package com.qrcafe.qrcafeback.entities;

import com.qrcafe.qrcafeback.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username")
    private String username;

    private String password;

    private String email;

    private String name;
    private String middleName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Status status;


    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;
}
