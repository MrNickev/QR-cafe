package com.qrcafe.qrcafeback.controllers;

import com.qrcafe.qrcafeback.entities.DecisionMaker;
import com.qrcafe.qrcafeback.entities.User;
import com.qrcafe.qrcafeback.services.DecisionMakerService;
import com.qrcafe.qrcafeback.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {

    private final UserService userService;
    private final DecisionMakerService decisionMakerService;

    @GetMapping("/unsecured")
    public String unsecuredData() {
        return "Unsecured data";
    }

    @GetMapping("/secured")
    public String securedData() {
        return "Secure data";
    }

    @GetMapping("/admin")
    public String adminData() {
        return "Admin data";
    }

    @GetMapping("/info")
    public User userData(Principal principal) {
        return userService.findByUsername(principal.getName()).get();
    }

    @GetMapping("/info/decision-maker")
    public DecisionMaker decisionMakerData(Principal principal) {
        return decisionMakerService.findByUsername(principal.getName()).get();
    }


}
