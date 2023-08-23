package com.qrcafe.qrcafeback.dto.registration;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegistrationDecisionMakerDto extends RegistartionUserDto{
    private String inn;
}
