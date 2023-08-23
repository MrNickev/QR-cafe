package com.qrcafe.qrcafeback.controllers;

import com.qrcafe.qrcafeback.dto.registration.RegistrationOrderDto;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/personal")
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/add/manager")
    public ResponseEntity<?> addNewManager(@RequestBody RegistrationOrderDto dto) {
        dto.setRole(Role.MANAGER);
        return staffService.createRegistrationOrder(dto);
    }


}
