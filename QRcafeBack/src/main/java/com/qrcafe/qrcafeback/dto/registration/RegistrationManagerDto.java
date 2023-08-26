package com.qrcafe.qrcafeback.dto.registration;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegistrationManagerDto extends RegistrationUserDto {
    private UUID restaurantId;
}
