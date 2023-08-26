package com.qrcafe.qrcafeback.services.staff;

import com.qrcafe.qrcafeback.dto.registration.RegistrationDecisionMakerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationManagerDto;
import com.qrcafe.qrcafeback.entities.DecisionMaker;
import com.qrcafe.qrcafeback.entities.staff.Manager;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.repositories.ManagerRepository;
import com.qrcafe.qrcafeback.services.RestaurantService;
import com.qrcafe.qrcafeback.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;

    public Manager createNewUser(RegistrationManagerDto registrationManagerDto) {
        var user = userService.createNewUser(registrationManagerDto, Role.MANAGER);
        var rest = restaurantService.findById(registrationManagerDto.getRestaurantId());
        Manager manager = new Manager();
        manager.setUser(user);
        rest.addManager(manager);
        return managerRepository.save(manager);
    }

    public Optional<Manager> findByUsername(String username) {
        var userId = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username))).getId();
        return managerRepository.findByUserId(userId);
    }

}
