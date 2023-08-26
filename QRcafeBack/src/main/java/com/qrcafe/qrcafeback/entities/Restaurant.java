package com.qrcafe.qrcafeback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qrcafe.qrcafeback.entities.staff.GeneralManager;
import com.qrcafe.qrcafeback.entities.staff.Manager;
import com.qrcafe.qrcafeback.entities.staff.Waiter;
import jakarta.persistence.*;
import lombok.Data;

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
    private GeneralManager generalManager;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
    private List<Manager> managers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
    private List<Waiter> waiters;


    public void addManager(Manager manager) {
        managers.add(manager);
        manager.setRestaurant(this);
    }

    public void setGeneralManager(GeneralManager generalManager) {
        this.generalManager = generalManager;
        generalManager.setRestaurant(this);
    }
}
