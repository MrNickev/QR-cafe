package com.qrcafe.qrcafeback.repositories;

import com.qrcafe.qrcafeback.entities.DecisionMaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DecisionMakerRepository extends CrudRepository<DecisionMaker, UUID> {
    Optional<DecisionMaker> findDecisionMakerByUserId(UUID user_id);
}
