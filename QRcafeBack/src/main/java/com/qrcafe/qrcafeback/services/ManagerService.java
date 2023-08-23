package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.registration.RegistrationManagerDto;
import com.qrcafe.qrcafeback.entities.Manager;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.enums.Status;
import com.qrcafe.qrcafeback.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

//    public Manager createNewUser(RegistrationManagerDto registrationUserDto) {
//        Manager user = new Manager();
//        user.setEmail(registrationUserDto.getEmail());
//        user.setUsername(registrationUserDto.getUsername());
//        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
//        user.setRole(Role.MANAGER);
//        user.setStatus(Status.ACTIVE);
//        user.setFirstName(registrationUserDto.getFirstName());
//        user.setMiddleName(registrationUserDto.getMiddleName());
//        user.setLastName(registrationUserDto.getLastName());
//        return managerRepository.save(user);
//    }

}
