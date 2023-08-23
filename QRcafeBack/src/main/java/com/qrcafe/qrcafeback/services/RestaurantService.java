package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.CreatingRestaurantDto;
import com.qrcafe.qrcafeback.entities.Restaurant;
import com.qrcafe.qrcafeback.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final DecisionMakerService decisionMakerService;

    private final RestaurantRepository restaurantRepository;

    public ResponseEntity<?> createNewRestaurant(String decisionMakerName, CreatingRestaurantDto restaurantDto) {

        var decisionMaker = decisionMakerService.findByUsername(decisionMakerName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", decisionMakerName)));

        var restaurant = new Restaurant();
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setName(restaurantDto.getName());
        decisionMaker.addRestaurant(restaurant);
//        decisionMakerService.save(decisionMaker);
        restaurantRepository.save(restaurant);
        return ResponseEntity.ok(restaurant);

    }

    public Restaurant findById(UUID id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Ресторан с id %s не найден", id)));
    }

}
