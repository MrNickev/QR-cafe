package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.registration.RegistrationDecisionMakerDto;
import com.qrcafe.qrcafeback.entities.DecisionMaker;
import com.qrcafe.qrcafeback.entities.User;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.enums.Status;
import com.qrcafe.qrcafeback.repositories.DecisionMakerRepository;
import com.qrcafe.qrcafeback.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DecisionMakerService {
    private final DecisionMakerRepository decisionMakerRepository;
    @Lazy
    private final UserService userService;

    public DecisionMaker createNewUser(RegistrationDecisionMakerDto registrationUserDto) {
        var user = userService.createNewUser(registrationUserDto);
        DecisionMaker dm = new DecisionMaker();
        dm.setInn(registrationUserDto.getInn());
        dm.setUser(user);
        return decisionMakerRepository.save(dm);
    }

    public Optional<DecisionMaker> findByUsername(String username) {
        var userId = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username))).getId();
        return decisionMakerRepository.findDecisionMakerByUserId(userId);

    }

    public DecisionMaker save(DecisionMaker decisionMaker) {
        return decisionMakerRepository.save(decisionMaker);
    }


}
