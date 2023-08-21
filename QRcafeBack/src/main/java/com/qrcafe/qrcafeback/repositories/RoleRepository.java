package com.qrcafe.qrcafeback.repositories;

import com.qrcafe.qrcafeback.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends CrudRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
