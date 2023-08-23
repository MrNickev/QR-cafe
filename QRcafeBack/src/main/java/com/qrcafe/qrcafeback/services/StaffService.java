package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.registration.RegistrationOrderDto;
import com.qrcafe.qrcafeback.entities.RegistrationOrder;
import com.qrcafe.qrcafeback.exceptions.AppError;
import com.qrcafe.qrcafeback.repositories.RegistrationOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffService {
       private final RegistrationOrderRepository registrationOrderRepository;

       public ResponseEntity<?> createRegistrationOrder(RegistrationOrderDto dto) {
           if (registrationOrderRepository.findByUsername(dto.getUsername()).isPresent()){
               return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Такой пользователь уже существует"), HttpStatus.BAD_REQUEST);
           }
           var order = new RegistrationOrder();
           order.setUsername(dto.getUsername());
           order.setEmail(dto.getEmail());
           order.setFirstName(dto.getFirstName());
           order.setMiddleName(dto.getMiddleName());
           order.setLastName(dto.getLastName());
           registrationOrderRepository.save(order);
           return ResponseEntity.ok(order);
       }


}
