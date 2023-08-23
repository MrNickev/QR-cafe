package com.qrcafe.qrcafeback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String address;

    @ManyToOne
    @JsonIgnore
    private DecisionMaker decisionMaker;

    @OneToOne
    private User generalManager;

    @OneToMany
    private List<User> managers;

    @OneToMany
    private List<Waiter> waiters;



}
