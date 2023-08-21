package com.qrcafe.qrcafeback.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class ClientTable {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
