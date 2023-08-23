package com.qrcafe.qrcafeback.controllers;

import com.qrcafe.qrcafeback.entities.Restaurant;
import com.qrcafe.qrcafeback.services.DecisionMakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/decisionMaker")
public class DecisionMakerController {
    private final DecisionMakerService decisionMakerService;

    @GetMapping("/restaurants")
    private List<Restaurant> getUserRests(Principal principal) {
        return decisionMakerService.findByUsername(principal.getName()).get().getRestaurants();
    }

}
