package com.project.stilgalleriet.repositories;

import com.project.stilgalleriet.models.ERole;
import com.project.stilgalleriet.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByRolePermission(ERole rolePermission); //En custom implementation metod
}
