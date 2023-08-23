package com.qrcafe.qrcafeback.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class DecisionMaker{
    @Id
    @GeneratedValue
    private UUID id;

    private String inn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "decisionMaker", orphanRemoval = true)
    private List<Restaurant> restaurants = new ArrayList<>();

    @OneToOne
    private User user;

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        restaurant.setDecisionMaker(this);
    }

}
