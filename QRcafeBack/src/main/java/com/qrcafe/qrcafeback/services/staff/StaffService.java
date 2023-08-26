package com.qrcafe.qrcafeback.services.staff;

import com.qrcafe.qrcafeback.dto.registration.RegistrationOrderDto;
import com.qrcafe.qrcafeback.entities.RegistrationOrder;
import com.qrcafe.qrcafeback.exceptions.AppError;
import com.qrcafe.qrcafeback.repositories.RegistrationOrderRepository;
import com.qrcafe.qrcafeback.services.EmailSenderService;
import com.qrcafe.qrcafeback.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffService {
       private final RegistrationOrderRepository registrationOrderRepository;
       private final RestaurantService restaurantService;
       private final EmailSenderService emailSenderService;

       public Optional<RegistrationOrder> findByEmail(String email) {
           return registrationOrderRepository.findByEmail(email);
       }

       public RegistrationOrder findById(Long id) {
              return registrationOrderRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Код регистрации не найден или недействителен"));
       }

       public ResponseEntity<?> createRegistrationOrder(RegistrationOrderDto dto) {
           var registrationOrder = new RegistrationOrder();
           registrationOrder.setFirstName(dto.getFirstName());
           registrationOrder.setLastName(dto.getLastName());
           registrationOrder.setEmail(dto.getEmail());
           registrationOrder.setRole(dto.getRole());
           registrationOrder.setRestaurant(restaurantService.findById(dto.getRestaurantId()));
           registrationOrderRepository.save(registrationOrder);

           //here must be sending email to new user
           emailSenderService.sendEmail(dto.getEmail(), "Welcome to QR-cafe team",
                   String.format("<h1>Поздравляем с прглашением, %s</h1>" +
                   "<p>Поздравляем с приглашением на работу! Мы рады, что Вы будете помогать гостям заведения ощутить комфорт, а мы сделаем все возможное, чтобы Вам было проще это делать.</p>" +
                           "<p>Чтобы зарегистрироваться в приложении QR-cafe, перейдите по ссылке: </p><a>http://localhost:8080/api/registration/manager/%s</a>", dto.getFirstName(), registrationOrder.getId()));

           return ResponseEntity.ok(String.format("Registration letter was sending to %s address. New %s will be added when create account", registrationOrder.getEmail(), registrationOrder.getRole()));
       }


}
