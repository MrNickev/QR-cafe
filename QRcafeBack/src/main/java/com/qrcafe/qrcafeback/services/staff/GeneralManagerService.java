package com.qrcafe.qrcafeback.services.staff;

import com.qrcafe.qrcafeback.dto.registration.RegistrationGeneralManagerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationManagerDto;
import com.qrcafe.qrcafeback.entities.staff.GeneralManager;
import com.qrcafe.qrcafeback.entities.staff.Manager;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.repositories.GeneralManagerRepository;
import com.qrcafe.qrcafeback.repositories.ManagerRepository;
import com.qrcafe.qrcafeback.services.RestaurantService;
import com.qrcafe.qrcafeback.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneralManagerService {
    private final GeneralManagerRepository managerRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;

    public GeneralManager createNewUser(RegistrationGeneralManagerDto registrationManagerDto) {
        var user = userService.createNewUser(registrationManagerDto, Role.GENERAL_MANAGER);
        var rest = restaurantService.findById(registrationManagerDto.getRestaurantId());
        GeneralManager manager = new GeneralManager();
        manager.setUser(user);
        rest.setGeneralManager(manager);
        return managerRepository.save(manager);
    }

    public Optional<GeneralManager> findByUsername(String username) {
        var userId = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username))).getId();
        return managerRepository.findByUserId(userId);
    }
}
