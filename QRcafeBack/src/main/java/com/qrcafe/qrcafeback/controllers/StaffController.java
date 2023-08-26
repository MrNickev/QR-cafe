package com.qrcafe.qrcafeback.controllers;

import com.qrcafe.qrcafeback.dto.registration.RegistrationOrderDto;
import com.qrcafe.qrcafeback.services.staff.StaffService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/add")
    public ResponseEntity<?> addManager(@RequestBody RegistrationOrderDto dto) {
        return staffService.createRegistrationOrder(dto);
    }

    @GetMapping("/get-info/{id}")
    public ResponseEntity<?> getInfo(@PathParam("id") Long id) {
        return ResponseEntity.ok(staffService.findById(id));
    }


}
