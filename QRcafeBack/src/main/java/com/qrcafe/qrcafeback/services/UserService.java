package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.dto.RegistartionUserDto;
import com.qrcafe.qrcafeback.entities.User;
import com.qrcafe.qrcafeback.enums.Status;
import com.qrcafe.qrcafeback.repositories.RoleRepository;
import com.qrcafe.qrcafeback.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User %s not found", username)));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public void createNewUser(RegistartionUserDto registartionUserDto) {
        User user = new User();
        user.setEmail(registartionUserDto.getEmail());
        user.setUsername(registartionUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(registartionUserDto.getPassword()));
        user.setRoles(List.of(roleService.findRole("DECISION_MAKER")));
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
    }
}
