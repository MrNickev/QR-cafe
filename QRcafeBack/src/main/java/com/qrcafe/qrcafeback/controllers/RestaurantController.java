package com.qrcafe.qrcafeback.controllers;

import com.qrcafe.qrcafeback.dto.CreatingRestaurantDto;
import com.qrcafe.qrcafeback.entities.Restaurant;
import com.qrcafe.qrcafeback.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewRestaurant(Principal principal, @RequestBody CreatingRestaurantDto restaurantDto) {
        log.info(restaurantDto.getName()+ " " + restaurantDto.getAddress());
        return restaurantService.createNewRestaurant(principal.getName(), restaurantDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getInfo(Principal principal, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(restaurantService.findById(id));
    }

}
