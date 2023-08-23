package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.JwtRequest;
import com.qrcafe.qrcafeback.dto.JwtResponse;
import com.qrcafe.qrcafeback.dto.registration.RegistartionUserDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationDecisionMakerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationManagerDto;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.exceptions.AppError;
import com.qrcafe.qrcafeback.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final DecisionMakerService decisionMakerService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    public ResponseEntity<?> createToken(JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Uncorrect login or password"), HttpStatus.BAD_REQUEST);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        var token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    public ResponseEntity<?> createNewUser(RegistartionUserDto registartionUserDto) {
        userService.createNewUser(
                registartionUserDto.getUsername(),
                registartionUserDto.getPassword(),
                registartionUserDto.getEmail(),
                registartionUserDto.getFirstName(),
                registartionUserDto.getMiddleName(),
                registartionUserDto.getLastName(),
                Role.DECISION_MAKER
                );
        UserDetails userDetails = userService.loadUserByUsername(registartionUserDto.getUsername());
        var token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(RegistrationDecisionMakerDto registartionUserDto) {
        if (userService.findByUsername(registartionUserDto.getUsername()).isPresent())
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Такой пользователь уже существует"), HttpStatus.BAD_REQUEST);

        decisionMakerService.createNewUser(registartionUserDto);
        UserDetails userDetails = userService.loadUserByUsername(registartionUserDto.getUsername());
        var token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(RegistrationManagerDto registartionUserDto) {
        if (userService.findByUsername(registartionUserDto.getUsername()).isPresent())
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Такой пользователь уже существует"), HttpStatus.BAD_REQUEST);

        userService.createNewUser(registartionUserDto);
        UserDetails userDetails = userService.loadUserByUsername(registartionUserDto.getUsername());
        var token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
