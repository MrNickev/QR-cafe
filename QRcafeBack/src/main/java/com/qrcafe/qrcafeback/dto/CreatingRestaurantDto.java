package com.qrcafe.qrcafeback.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreatingRestaurantDto {
    private String name;
    private String address;
}
