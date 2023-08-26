package com.qrcafe.qrcafeback.repositories;

import com.qrcafe.qrcafeback.entities.staff.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, UUID> {
    Optional<Manager> findByUserId(UUID userId);
}
