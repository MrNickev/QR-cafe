package com.qrcafe.qrcafeback.controllers;

import com.qrcafe.qrcafeback.dto.JwtRequest;
import com.qrcafe.qrcafeback.dto.RegistartionUserDto;
import com.qrcafe.qrcafeback.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createToken(@RequestBody JwtRequest authRequest) {
        return authService.createToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistartionUserDto registartionUserDto) {
        return authService.createNewUser(registartionUserDto);

    }

}
