package com.qrcafe.qrcafeback.repositories;

import com.qrcafe.qrcafeback.entities.Manager;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ManagerRepository extends CrudRepository<Manager, UUID> {

}
