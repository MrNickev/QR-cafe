package com.qrcafe.qrcafeback.entities.staff;

import com.qrcafe.qrcafeback.entities.Restaurant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Manager extends Staff{

}
