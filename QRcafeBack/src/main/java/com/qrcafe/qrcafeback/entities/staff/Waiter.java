package com.qrcafe.qrcafeback.entities.staff;

import com.qrcafe.qrcafeback.entities.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Waiter extends Staff {

}
