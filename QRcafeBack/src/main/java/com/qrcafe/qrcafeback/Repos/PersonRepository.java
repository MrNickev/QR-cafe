package com.qrcafe.qrcafeback.Repos;

import com.qrcafe.qrcafeback.Entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {
    Optional<Person> findByEmail(String email);
}
