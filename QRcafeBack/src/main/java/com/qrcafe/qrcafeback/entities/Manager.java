package com.qrcafe.qrcafeback.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@Entity
public class Manager{
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Restaurant restaurant;
}
