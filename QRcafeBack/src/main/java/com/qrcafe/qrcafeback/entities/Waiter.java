package com.qrcafe.qrcafeback.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("WA")
public class Waiter extends User{
    @ManyToOne
    private Restaurant restaurant;
}
