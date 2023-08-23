package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.registration.RegistartionUserDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationDecisionMakerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationManagerDto;
import com.qrcafe.qrcafeback.entities.DecisionMaker;
import com.qrcafe.qrcafeback.entities.User;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.enums.Status;
import com.qrcafe.qrcafeback.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User %s not found", username)));
        String role = user.getRole().name();
        var roles = new ArrayList<String>();
        roles.add(role);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );
    }

    public User createNewUser(String username, String password, String email, String firstname, String middleName, String lastName, Role role) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setFirstName(firstname);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.DECISION_MAKER);
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    public User createNewUser(RegistrationDecisionMakerDto registrationDecisionMakerDto) {
        var user = createNewUser(
                registrationDecisionMakerDto.getUsername(),
                registrationDecisionMakerDto.getPassword(),
                registrationDecisionMakerDto.getEmail(),
                registrationDecisionMakerDto.getFirstName(),
                registrationDecisionMakerDto.getMiddleName(),
                registrationDecisionMakerDto.getLastName(),
                Role.DECISION_MAKER
        );
        return user;
    }

    public void createNewUser(RegistrationManagerDto registrationManagerDto) {
//        var manager = managerService.createNewUser(registrationManagerDto);
//        createNewUser(
//                manager.getId(),
//                registrationManagerDto.getUsername(),
//                registrationManagerDto.getPassword(),
//                registrationManagerDto.getEmail(),
//                registrationManagerDto.getFirstName(),
//                registrationManagerDto.getMiddleName(),
//                registrationManagerDto.getLastName(),
//                Role.MANAGER
//        );
    }

}
