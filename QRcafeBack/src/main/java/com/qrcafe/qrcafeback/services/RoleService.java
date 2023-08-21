package com.qrcafe.qrcafeback.services;

import com.qrcafe.qrcafeback.entities.Role;
import com.qrcafe.qrcafeback.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findRole(String name) {
        return roleRepository.findByName(name).get();
    }
}
