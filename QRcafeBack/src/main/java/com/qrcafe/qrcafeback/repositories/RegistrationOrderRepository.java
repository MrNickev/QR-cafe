package com.qrcafe.qrcafeback.repositories;

import com.qrcafe.qrcafeback.entities.RegistrationOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RegistrationOrderRepository extends CrudRepository<RegistrationOrder, UUID> {
    Optional<RegistrationOrder> findByUsername(String username);

}
