package com.qrcafe.qrcafeback.controllers;

import com.qrcafe.qrcafeback.dto.JwtRequest;
import com.qrcafe.qrcafeback.dto.registration.RegistrationUserDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationDecisionMakerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationGeneralManagerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationManagerDto;
import com.qrcafe.qrcafeback.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000/")
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createToken(@RequestBody JwtRequest authRequest) {
        return authService.createToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody RegistrationUserDto dto) {
        return authService.createNewUser(dto);

    }

    @PostMapping("/registration/decisionMaker")
    public ResponseEntity<?> createNewDecisionMaker(@RequestBody RegistrationDecisionMakerDto registartionUserDto) {
        log.info(registartionUserDto.toString());
        return authService.createNewUser(registartionUserDto);
    }

    @PostMapping("/registration/manager")
    public ResponseEntity<?> createNewManager(@RequestBody RegistrationManagerDto registartionUserDto) {
        return authService.createNewUser(registartionUserDto);
    }

    @PostMapping("/registration/general_manager")
    public ResponseEntity<?> createNewGm(@RequestBody RegistrationGeneralManagerDto dto) {
        return authService.createNewUser(dto);
    }




}
