package com.qrcafe.qrcafeback.repositories;

import com.qrcafe.qrcafeback.entities.staff.GeneralManager;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface GeneralManagerRepository extends CrudRepository<GeneralManager, UUID> {
    Optional<GeneralManager> findByUserId(UUID userId);
}
