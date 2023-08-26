package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.registration.RegistrationDecisionMakerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationManagerDto;
import com.qrcafe.qrcafeback.dto.registration.RegistrationUserDto;
import com.qrcafe.qrcafeback.entities.User;
import com.qrcafe.qrcafeback.enums.Role;
import com.qrcafe.qrcafeback.enums.Status;
import com.qrcafe.qrcafeback.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
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
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

//    public User createNewUser(RegistrationDecisionMakerDto registrationDecisionMakerDto) {
//        return createNewUser(
//                registrationDecisionMakerDto.getUsername(),
//                registrationDecisionMakerDto.getPassword(),
//                registrationDecisionMakerDto.getEmail(),
//                registrationDecisionMakerDto.getFirstName(),
//                registrationDecisionMakerDto.getMiddleName(),
//                registrationDecisionMakerDto.getLastName(),
//                Role.DECISION_MAKER
//        );
//    }
//
//    public User createNewUser(RegistrationManagerDto registrationManagerDto) {
//        return createNewUser(
//                registrationManagerDto.getUsername(),
//                registrationManagerDto.getPassword(),
//                registrationManagerDto.getEmail(),
//                registrationManagerDto.getFirstName(),
//                registrationManagerDto.getMiddleName(),
//                registrationManagerDto.getLastName(),
//                Role.MANAGER
//        );
//    }

    public User createNewUser(RegistrationUserDto registrationManagerDto, Role role) {
        return createNewUser(
                registrationManagerDto.getUsername(),
                registrationManagerDto.getPassword(),
                registrationManagerDto.getEmail(),
                registrationManagerDto.getFirstName(),
                registrationManagerDto.getMiddleName(),
                registrationManagerDto.getLastName(),
                role
        );
    }


}
