package com.qrcafe.qrcafeback.entities.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qrcafe.qrcafeback.entities.Restaurant;
import com.qrcafe.qrcafeback.entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@MappedSuperclass
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    @OneToOne
    private User user;

}
